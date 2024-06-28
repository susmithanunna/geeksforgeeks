//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        if(s.length()<=2){
            return -1;
        }
       String t=s.substring(0,3);
       int l=0;
       int r=3;
       int min=Integer.MAX_VALUE;
       while(l<r && r<=s.length()){
           if(t.contains("1") && t.contains("0") && t.contains("2")){
                 min=(int)Math.min(min,r-l);
                      
                       l++;
                        
                       if(l>=r){
                         break;
                     }
                     t=s.substring(l,r);
                     
               
           }
           else{
               r++;
               if(r>s.length()){
                   break;
               }
               t=s.substring(l,r);
           }
       }
       return min==Integer.MAX_VALUE?-1:min;
    }
};
