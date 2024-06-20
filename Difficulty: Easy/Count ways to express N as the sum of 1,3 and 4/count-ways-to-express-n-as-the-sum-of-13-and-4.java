//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countWays(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long countWays(int N) {
        // code here
        int mod=(int)Math.pow(10,9)+7;
        if(N<=2){
            return 1l;
        }
        else if(N==3){
            return 2l;
        }
        long dp[]=new long[N+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=N;i++){
            dp[i]=(dp[i-4]+dp[i-3]+dp[i-1])%mod;
        }
        return dp[N];
    }
};