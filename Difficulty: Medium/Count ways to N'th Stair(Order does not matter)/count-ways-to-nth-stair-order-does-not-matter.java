//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public long nthStair(int n) {
        // Code here
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=2;i++){
            for(int j=i;j<=n;j++){
                dp[j]=dp[j]+dp[j-i];
            }
        }
        return dp[n];
    }
}