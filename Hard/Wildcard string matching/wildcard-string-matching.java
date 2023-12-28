//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        int n1=wild.length();
        int n2=pattern.length();
        return wildcard(n1-1,n2-1,wild,pattern);
    }
    static boolean wildcard(int n1,int n2,String wild,String pattern){
        if(n1<0 && n2<0){
            return true;
        }
        if(n1<0 && n2>=0){
            return false;
        }
        if(n1>=0 && n2<0){
            for(int i=0;i<n1;i++){
                if(wild.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(pattern.charAt(n2)==wild.charAt(n1) || wild.charAt(n1)=='?'){
            return wildcard(n1-1,n2-1,wild,pattern);
        }
        if(wild.charAt(n1)=='*'){
            return wildcard(n1-1,n2,wild,pattern) || wildcard(n1,n2-1,wild,pattern);
        }
        return false;
        
    }
}