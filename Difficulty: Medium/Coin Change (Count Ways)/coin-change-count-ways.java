//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int c=0;
       // int c1=find(coins,sum,0,c);
       int n=coins.length;
        int dp[]=new int[sum+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=sum;j++){
                if(j-coins[i]>=0){
                    dp[j]=dp[j]+dp[j-coins[i]];
                }
               
            }
        }
        return dp[sum];
    }
    public int find(int coins[],int sum,int i,int c){
        if(i>coins.length-1 && sum!=0){
            return 0;
        }
         if(sum==0){
            return 1;
        }
        int take=0;
        if(sum-coins[i]>=0){
            take=1+find(coins,sum-coins[i],i,c);
        }
        int nottake=find(coins,sum,i+1,c);
        return (int)Math.max(take,nottake);
    }
}