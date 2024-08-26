//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int n1=pattern.length();
        int n2=str.length();
        int dp[][]=new int[n1+1][n2+1];
        dp[0][0]=1;
        for(int j=1;j<=n2;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n1;i++){
            int flag=1;
            for(int k=1;k<=i;k++){
                if(pattern.charAt(k-1)!='*'){
                    flag=0;
                    break;
                }
            }
          dp[i][0]=flag;
            
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(pattern.charAt(i-1)==str.charAt(j-1) || pattern.charAt(i-1)=='?'){
                 dp[i][j]=dp[i-1][j-1];
                }
                else if(pattern.charAt(i-1)=='*'){
                    int t=dp[i-1][j]+dp[i][j-1];
                    if(t==0){
                        dp[i][j]=0;
                    }
                    else{
                      dp[i][j]=1; 
                    }
                    
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[n1][n2];
    }
    
}
