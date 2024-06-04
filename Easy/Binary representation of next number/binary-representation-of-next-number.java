//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        String ans="";
        int n=s.length();
        int c=0;
        while(c<n && s.charAt(c)=='0'){
            c++;
        }
        if(c==n){
            return "1";
        }
        s=s.substring(c,n);
        n=s.length();
        if(s.charAt(n-1)=='0'){
            return s.substring(0,n-1)+"1";
        }
        else{
            int i=n-1;
            
            while(i>=0 && s.charAt(i)=='1'){
                ans=ans+"0";
                i--;
            }
            //System.out.println(ans);
            if(i>=0){
                ans=s.substring(0,i)+"1"+ans;
            }
            else{
                ans="1"+ans;
                //ans=s.substring(0,i)+ans;
            }
        }
        // int c=0;
        // int n1=ans.length();
        // while(ans.charAt(c)=='0'){
        //     c++;
        // }
        // System.out.println("ans "+ans.substring(c,n1));
        //ans=ans.substring(c,n1);
        return ans;
        
    }
}