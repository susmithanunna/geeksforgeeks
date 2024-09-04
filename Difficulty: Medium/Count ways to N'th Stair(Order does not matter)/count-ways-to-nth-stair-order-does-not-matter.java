//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public long nthStair(int n) {
        // Code here
      
       if(n==1){
           return 1;
       }
       else if(n==2){
           return 2;
       }
        long dp[]=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            if(i%2==0){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n];
        
    }
}