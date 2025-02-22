//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String S) {
        // code here
       int left=0;
       int right=0;
       int maxi=0;
       for(int i=0;i<S.length();i++){
           if(S.charAt(i)=='(')  left++;
           else right++;
           if(left==right) {
               maxi=(int)Math.max(maxi,left*2);
           }
           else if (left<right){
               left=0;
               right=0;
           }
       }
       
       left=0;
       right=0;
       for(int i=S.length()-1;i>=0;i--){
           if(S.charAt(i)=='(')  left++;
           else right++;
           
           if(left==right) {
               maxi=(int)Math.max(maxi,left*2);
           }
           else if (left>right){
               left=0;
               right=0;
           }
       }
       return maxi;
    }
}