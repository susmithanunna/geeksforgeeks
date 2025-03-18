//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum=0;
        int N=arr.length;
        for(int i=0;i<N;i++){
            sum=sum+arr[i];
        }
        if(sum%2!=0){
            return false;
        }
        
        int t=sum/2;
        boolean dp[][]=new boolean[N+1][t+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=t;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
                if(i!=0 && arr[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                }
                else if(i!=0){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][t]==true?true:false;
    }
}