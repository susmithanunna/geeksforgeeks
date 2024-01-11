//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
             while(K>0 && !s1.isEmpty() && s1.peek()>c){
                 s1.pop();
                 K--;
             }
             if(s1.isEmpty() && c=='0'){
                 continue;
             }
             else{
                 s1.push(c);
             }
             
        }
        while(K>0 && !s1.isEmpty()){
            s1.pop();
            K--;
        }
        if(s1.size()==0){
            return "0";
        }
        StringBuilder ans=new StringBuilder();
        while(!s1.isEmpty()){
            ans.append(s1.pop());
        }
       return ans.reverse().toString();
    }
}