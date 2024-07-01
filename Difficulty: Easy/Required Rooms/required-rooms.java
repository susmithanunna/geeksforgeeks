//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.rooms(N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int rooms(int N, int M){
        // code here
        int c=gcd(N,M);
        return N/c+M/c;
        //return gcd(N,M);
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}