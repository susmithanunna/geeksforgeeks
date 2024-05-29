//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        int dp[]=new int[n+1];
        dp[0]=0;//intially no player will win
        dp[1]=1;//if coin is 1 then geek pick that one coin and win
        for(int i=2;i<=n;i++){
            if(i-1>=0 && dp[i-1]==0){
                dp[i]=1;
            }
            else if(i-x>=0 && dp[i-x]==0){
                dp[i]=1;
            }
            else if(i-y>=0 && dp[i-y]==0){
                dp[i]=1;
            }
            else{
                dp[i]=0;
            }
        }
        return dp[n];
    }
}
