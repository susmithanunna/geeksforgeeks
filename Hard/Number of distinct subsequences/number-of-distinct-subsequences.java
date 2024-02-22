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
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        // code here
        HashMap<Character,Integer> h1=new HashMap<>();
        int mod=(int)Math.pow(10,9)+7;
        int n=S.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            dp[i]=(dp[i-1]*2)%mod;
            char c=S.charAt(i-1);
            if(h1.containsKey(c)){
                dp[i]=(dp[i]-(dp[h1.get(c)-1])%mod+mod)%mod;
                
            }
            h1.put(c,i);
        }
        return dp[n];
    }
}