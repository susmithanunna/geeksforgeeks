//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long dp[][]=new long[n+1][n+1];
        //Arrays.fill(dp,-1);
        long ans=find(arr,0,n-1,dp);
        return ans;
    }
    static long find(int arr[],int left,int right,long dp[][]){
        if(left>right){
            return 0;
        }
        if(left==right){
            return arr[left];
        }
        if(dp[left][right]!=0)
        {
            return dp[left][right];
        }
        long l=arr[left]+(long)Math.min(find(arr,left+2,right,dp),find(arr,left+1,right-1,dp));
        long r=arr[right]+(long)Math.min(find(arr,left,right-2,dp),find(arr,left+1,right-1,dp));
        return dp[left][right]=(long)Math.max(l,r);
    }
}
