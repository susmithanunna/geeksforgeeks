//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String nums="";
        long ans=-1;
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)>='0' && sentence.charAt(i)<'9'){
                nums=nums+sentence.charAt(i);
                //System.out.println(nums);
            }
            else if(nums.length()!=0){
                //nums.trim();
                long t=Long.parseLong(nums);
                ans=Math.max(ans,t);
                nums="";
            }
        }
        return ans;
    }
}