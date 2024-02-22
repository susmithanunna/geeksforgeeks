//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int  subsequenceCount(String s, String t)
    {
	// Your code here
	  int n1=t.length();
	  int n2=s.length();
	  int mod=(int)Math.pow(10,9)+7;
	  if(n1>n2){
	      return 0;
	  }
	  int dp[][]=new int[n1+1][n2+1];
	  for(int j=0;j<=n2;j++){
	      dp[0][j]=1;
	  }
	  for(int i=1;i<=n1;i++){
	      for(int j=1;j<=n2;j++){
	          if(t.charAt(i-1)==s.charAt(j-1)){
	              dp[i][j]=(dp[i-1][j-1]+dp[i][j-1])%mod;
	          }
	          else{
	              dp[i][j]=(dp[i][j-1])%mod;
	          }
	      }
	  }
	  return dp[n1][n2];
    }
}