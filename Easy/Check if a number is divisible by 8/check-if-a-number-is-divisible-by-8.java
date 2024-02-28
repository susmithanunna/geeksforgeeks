//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        //code here
        int n=s.length();
        if(n<3){
            int n1=Integer.parseInt(s);
            if(n1%8==0){
                return 1;
            }
            return -1;
        }
        else{
            int n1=Integer.parseInt(s.substring(n-3,n));
            if(n1%8==0){
                return 1;
            }
        }
        return -1;
    }
}