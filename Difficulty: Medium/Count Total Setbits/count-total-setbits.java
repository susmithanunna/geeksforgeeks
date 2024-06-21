//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countBits(int n) {
        // code here
        int dp[]=new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i/2]+i%2;
            sum=sum+dp[i];
        }
        return sum;
    }
}