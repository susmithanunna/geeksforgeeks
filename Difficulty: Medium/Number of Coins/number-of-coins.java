//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int dp[]=new int[V+1];
	    Arrays.fill(dp,Integer.MAX_VALUE-1);
	    dp[0]=0;
	    for(int i=1;i<=V;i++){
	        for(int j=0;j<M;j++){
	            if(coins[j]<=i){
	                dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
	            }
	        }
	    }
	   // for(int i=0;i<=V;i++){
	   //     System.out.print(dp[i]+" ");
	   // }
	    return dp[V]==Integer.MAX_VALUE-1?-1:dp[V];
	} 
}