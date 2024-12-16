//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        
       int n=txt.length();
       int m=pat.length();
       int lps[]=new int[m];
       //calculating lps
       lps[0]=0;
       int j=0;
       ArrayList<Integer> ans=new ArrayList<>();
       int i=1;
      while(i<m){
           if(pat.charAt(i)==pat.charAt(j)){
               j++;
               lps[i]=j;
               i++;
           }
           else{
               if(j!=0){
                  j=lps[j-1];
               }
               else{
                   lps[i]=0;
                   i++;
               }
           }
       }
       j=0;
        i=0;
      while(i<n){
           if(txt.charAt(i)==pat.charAt(j)){
               j++;
               i++;
           }
           if(j==m){
               ans.add(i-j);
               j=lps[j-1];
           }
           else if(i<n && txt.charAt(i)!=pat.charAt(j)){
               if(j!=0){
                   j=lps[j-1];
               }
               else{
                   i++;
               }
           }
       }
       return ans;
       
    
        
    }
}