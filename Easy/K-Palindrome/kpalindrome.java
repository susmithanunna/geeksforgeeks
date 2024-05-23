//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kPalindrome(String str, int n, int k) {
        // code here
        // if(n<k){
        //     return 0;
        // }
        // HashMap<Character,Integer> h1=new HashMap<>();
        // Integer c;
        // int a1=0;
        // for(int i=0;i<str.length();i++){
        //     c=h1.get(str.charAt(i));
        //     if(c==null){
        //         c=0;
        //     }
        //     h1.put(str.charAt(i),c+1);
        // }
        // for(char c1:h1.keySet()){
        //     if(h1.get(c1)%2==1){
        //         a1++;
        //     }
        // }
        // if(a1>k){
        //     return 0;
        // }
        // return 1;
        String r="";
        for(int i=n-1;i>=0;i--){
            r=r+str.charAt(i);
        }
        int a1=lcs(str,r);
        if((n-a1)<=k){
            return 1;
        }
        return 0;
        
        
    }
    public int lcs(String s,String r){
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=(int)Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}