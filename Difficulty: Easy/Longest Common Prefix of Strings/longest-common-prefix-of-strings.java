//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String ans="";
        int n=arr.length;
        for(int i=1;i<n;i++){
            int j=0;
            int k=0;
            String s="";
            while(j<arr[i-1].length() && k<arr[i].length()){
                if(arr[i-1].charAt(j)==arr[i].charAt(k)){
                    s=s+arr[i].charAt(j);
                     j++;
                     k++;
                    
                }
                else{
                    break;
                }
            }
            j=0;
            k=0;
            if(i!=1){
                while(j<ans.length() && k<s.length()){
                    if(ans.charAt(j)==s.charAt(k)){
                        k++;
                        j++;
                    }
                    else{
                        break;
                    }
                }
                ans=ans.substring(0,k);
            }
            else{
                ans=s;
            }
            
        }
        if(arr.length==1){
            return arr[0];
        }
        return ans.length()==0?"-1":ans;
    }
}