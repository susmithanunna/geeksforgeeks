//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        int n1=str1.length();
        int n2=str2.length();
        int ans1=find(str1);
        int ans2=find(str2);
        if(ans1==ans2){
            return str1;
        }
        if(ans1>ans2){
            return str1;
        }
        return str2;
    }
    public static int find(String s1){
        int ans[]=new int[26];
        Arrays.fill(ans,-1);
        int c=1;
        for(int i=0;i<s1.length();i++){
            if(ans[s1.charAt(i)-'a']==-1){
                ans[s1.charAt(i)-'a']=c;
                c=c*2;
            }
            else{
                int t=ans[s1.charAt(i)-'a'];
                ans[s1.charAt(i)-'a']=c;
                c=c*2;
                c=c-t;
            }
            
        }
        return c;
    }
}