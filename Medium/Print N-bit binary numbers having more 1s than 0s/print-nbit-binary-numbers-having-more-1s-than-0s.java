//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        String s="";
        find(s,0,N,ans);
        return ans;
        
    }
    void find(String s,int i,int l,ArrayList<String> ans){
        if(l==0){
            ans.add(s);
            return;
        }
        find(s+"1",i+1,l-1,ans);
        if(i>0){
            find(s+"0",i-1,l-1,ans);
        }
    }
}