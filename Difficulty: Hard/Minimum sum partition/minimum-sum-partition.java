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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    if(n==1){
	        return nums[0];
	    }
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        for(int i=sum/2;i>0;i--){
            if(subsetSum(nums,i)){
                return sum-2*i;
            }
        }
        return 0;
	} 
	
    public Boolean subsetSum(int nums[],int sum){
        int n=nums.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
                if(i-1>=0 && nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else if(i-1>=0){
                    dp[i][j]=dp[i-1][j];
                }
            }
          
        }
          return dp[n][sum];
    }
}
