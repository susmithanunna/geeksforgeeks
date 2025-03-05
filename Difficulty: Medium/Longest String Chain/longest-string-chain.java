//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        // code here
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
       HashMap<String,Integer> dp=new HashMap<>();
       int max=0;
       for(String w:words){
           int curr=0;
           for(int i=0;i<w.length();i++){
               String prediction=w.substring(0,i)+w.substring(i+1,w.length());
               curr=(int)Math.max(curr,dp.getOrDefault(prediction,0)+1);
           }
           dp.put(w,curr);
           max=(int)Math.max(max,curr);
       }
       return max;
    }
}
//a b ba bca bda bdca
//