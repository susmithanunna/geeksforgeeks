//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int nthPoint(int n)
    {
        // Code here
        // int a=1;
        // int b=1;
        // int c=0;
        // for(int i=1;i<n;i++){
        //     c=(a+b)%1000000007;
        //     a=b%1000000007;
        //     b=c%1000000007;
        // }
        // return b;
        // int mod=(int)Math.pow(10,9)+7;
        // if(n==1){
        //     return 1;
        // }
        // else if(n==2){
        //     return 2;
        // }
        // return (nthPoint(n-1)+nthPoint(n-2))%mod;
        int mod=(int)Math.pow(10,9)+7;
        int dp[]=new int[n];
        if(n==1){
            return 1;
        }
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        return dp[n-1];
    }
}