//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestSubstring(String s) {
        // code here
        int n=s.length();
        int r=0;
        int l=0;
        int max=0;
        String ans="";
        while(r<n){
            String t1=s.substring(l,r+1);
            String t2=s.substring(r+1,n);
            if(t2.indexOf(t1)!=-1){
                if(max<r-l+1){
                    max=r-l+1;
                    ans=t1;
                }
                r++;
            }
            else{
               l++; 
            }
        }
        return ans.equals("")?"-1":ans;
    }
};