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
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.countSubstringWithEqualEnds(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countSubstringWithEqualEnds(String s) {
        // code here
        HashMap<Character,Integer> h1=new HashMap<>();
        Integer c;
        int n=s.length();
        int ans=n;
        
        for(int i=0;i<n;i++){
            c=h1.get(s.charAt(i));
            if(c==null){
                c=0;
            }
            h1.put(s.charAt(i),c+1);
            ans=ans+h1.get(s.charAt(i))-1;
        }
        
        // for(Character c1:h1.keySet()){
        //     if(h1.get(c1)>=2){
        //         ans+=h1.get(c1);
        //     }
        // }
        return ans;
    }
}