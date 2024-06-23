//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        if((sum+d)%2!=0){
            return 0;
        }
        int s1=(sum+d)/2;
        
        int dp[][]=new int[n+1][s1+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(j==0){
                    dp[i][j]=1;
                }
                if(i-1>=0 && arr[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%mod;
                }
                else if(i-1>=0){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][s1];
    }
}
        
