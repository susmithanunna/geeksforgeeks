//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int n1=str1.length();
        int n2=str2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n2;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int t1=(int)Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=1+(int)Math.min(dp[i-1][j-1],t1);
                }
            }
        }
        return dp[n1][n2];
    }
}