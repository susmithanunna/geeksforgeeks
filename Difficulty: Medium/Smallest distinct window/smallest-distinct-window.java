//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n=str.length();
        HashSet<Character> h1=new HashSet<>();
        for(int i=0;i<n;i++){
            h1.add(str.charAt(i));
        }
        int i=0;
        int j=0;
       HashMap<Character,Integer> hm=new HashMap<>();
       int cnt=Integer.MAX_VALUE;
       while(i<n){
           Integer c1=hm.get(str.charAt(i));
           if(c1==null){
               c1=0;
           }
           hm.put(str.charAt(i),c1+1);
           if(hm.size()==h1.size()){
               while(hm.size()==h1.size()){
                   cnt=(int)Math.min(cnt,i-j+1);
                   hm.put(str.charAt(j),hm.get(str.charAt(j))-1);
                   if(hm.get(str.charAt(j))==0){
                       hm.remove(str.charAt(j));
                   }
                   j++;
               }
           }
           i++;
       }
       return cnt;
    }
}