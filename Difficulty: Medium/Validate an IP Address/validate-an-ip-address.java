//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        int ans=0;
        String s="";
        int c=0;
        int zero_count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                c++;
                if(zero_count>0 && Integer.valueOf(s)>0){
                    return false;
                }
                //System.out.println(Integer.valueOf(s));
                if(s.length()==0 || (Integer.valueOf(s)>255 || Integer.valueOf(s)<-1)){
                    return false;
                }
                zero_count=0;
                s="";
            }
            else {
                if(str.charAt(i)=='0' && s.length()==0){
                    zero_count++;
                }
                s=s+str.charAt(i);
            }
        }
        if(zero_count>0 && Integer.valueOf(s)>0){
                    return false;
        }
       // System.out.println(Integer.valueOf(s));
        if(s.length()==0 || (Integer.valueOf(s)>255 || Integer.valueOf(s)<-1)){
            return false;
        }
 
        
        if(c==3)
        return true;
        return false;
    }
}