//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n1=str1.length();
	    int n2=str2.length();
	    int dp[][]=new int[n1+1][n2+1];
	    for(int i=0;i<=n1;i++){
	        for(int j=0;j<=n2;j++){
	            if(i==0 || j==0){
	                dp[i][j]=0;
	            }
	            else if(str1.charAt(i-1)==str2.charAt(j-1)){
	                dp[i][j]=1+dp[i-1][j-1];
	            }
	            else{
	                dp[i][j]=(int)Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	    }
	    return (int)Math.abs(dp[n1][n2]-n1)+(int)Math.abs(dp[n1][n2]-n2);
	} 
}