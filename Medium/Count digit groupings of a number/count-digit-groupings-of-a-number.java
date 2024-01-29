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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dp[][];
    public int TotalCount(String str)
    {
        // Code here
        dp=new int[101][1001];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        
        return grouping(str,0,0);
    }
    public int grouping(String str,int sum,int index){
        int c_sum=0;
        int ans=0;
        if(index>=str.length()){
            return 1;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        for(int i=index;i<str.length();i++){
            c_sum=c_sum+(int)(str.charAt(i)-'0');
            if(c_sum>=sum){
                ans=ans+grouping(str,c_sum,i+1);
            }
            
        }
        return dp[index][sum]=ans;
    }
}