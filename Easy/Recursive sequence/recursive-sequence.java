//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        // code here
        long sum = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        int c = 1;

     for (int i = 1; i <= n; i++) {
        long pro = 1;
        int c1 = i;
        while (c1 != 0) {
            pro = (pro * c) % mod;
            c1--;
            c++;
        }
         sum = (sum + pro % mod) % mod;  
    }
        return sum%mod;
    }
}