//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        int dp[][]=new int [n+1][n+1];
        int st=-1;
        int ed=-1;
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(max<dp[i][j]){
                        if(i+j==dp[i][j]+n){
                            max=dp[i][j];
                            ed=i;
                        }
                    }
                }
                
            }
        }
        return s.substring(ed-max,ed);
       
    }
}