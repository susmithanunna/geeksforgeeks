//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        // code here
        int n=s.length();
        int max=0;
        int end=n;
        int dp[][]=new int[n+1][n+1];
        StringBuilder r1=new StringBuilder(s).reverse();
        String r=r1.toString();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else  if(s.charAt(i-1)==r.charAt(j-1)){
                        
                    dp[i][j]=1+dp[i-1][j-1];
                    if(max<dp[i][j]){
                        if(i+j==dp[i][j]+n){
                        max=dp[i][j];
                        end=i;}
                    }
                    
                }
                
            }
        }
        return s.substring(end-max,end);
        
    }
}