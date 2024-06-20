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
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        // code here
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        StringBuilder s1=new StringBuilder(s);
       String s2= s1.reverse().toString();
        for(int i=0;i<=n;i++){
           // int k=n-1;
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else {
                    if(s.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                        //k--;
                    }
                    else{
                        dp[i][j]=(int)Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                    //k--;
                }
            }
        }
        return n-dp[n][n];
    }
}