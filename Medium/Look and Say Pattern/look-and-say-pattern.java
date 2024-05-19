//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        //your code here
        if(n==1){
            return "1";
        }
        String t=lookandsay(n-1);
        t=t+"#";
        String ans="";
        int c=1;
        for(int i=1;i<t.length();i++){
            if(t.charAt(i)==t.charAt(i-1)){
                c++;
            }
            else{
                ans=ans+String.valueOf(c);
                ans=ans+t.charAt(i-1);
                c=1;
            }
        }
        return ans;
    }
}
