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
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int a[] = new int[n];
                    int b[] = new int[m];
                    for(int i = 0;i<n;i++)
                        a[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        b[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, a, b));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		int dp[]=new int[m+1];
		for(int i=0;i<n;i++){
		    for(int j=(int)Math.min(m,i+1);j>0;j--){
		        dp[j]=(int)Math.max(dp[j],a[i]*b[j-1]+dp[j-1]);
		    }
		}
		return dp[m];
	} 
// 	public int helper(int n,int m,int a[],int b[]){
// 	    if (n == 0 || m == 0) return 0;

// 	    int dp[][]=new int[n+1][m+1];
// 	   // for(int i=0;i<=n;i++){
// 	   //     for(int j=0;j<=m;j++){
// 	   //         dp[i][j]=Integer.MIN_VALUE;
// 	   //     }
// 	   // }
// 	   for (int i = 0; i <= n; i++) {
//             for (int j = 0; j <= m; j++) {
//                 dp[i][j] = 0;
//             }
//         }
// 	    for(int i=1;i<=n;i++){
// 	        for(int j=1;j<=m;j++){
// 	            int pro=a[i-1]*b[j-1];
// 	            dp[i][j]=(int)Math.max(pro,dp[i-1][j-1]+pro);
// 	            dp[i][j]=(int)Math.max(dp[i][j],dp[i][j-1]);
// 	            dp[i][j]=(int)Math.max(dp[i][j],dp[i-1][j]);
// 	            //dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
// 	        }
// 	    }
// 	    return dp[n][m];
// 	}
}
