//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n=prices.length;
        int profit=0;     //n,buy,cap
        int dp[][][]=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return find(0,n,1,prices,profit,dp,2);
    }
    public static int find(int i,int n,int buy,int prices[],int profit,int dp[][][],int cap){
        if(cap==0 || i>n-1){
            return 0;
        }
        if(dp[i][buy][cap]!=-1){
            return dp[i][buy][cap];
        }
        if(buy==1){
            dp[i][buy][cap]=(int)Math.max(-prices[i]+find(i+1,n,0,prices,profit,dp,cap),0+find(i+1,n,1,prices,profit,dp,cap));
        }
        else{
            dp[i][buy][cap]=(int)Math.max(prices[i]+find(i+1,n,1,prices,profit,dp,cap-1),0+find(i+1,n,0,prices,profit,dp,cap));
        }
        return dp[i][buy][cap];
    }
}
