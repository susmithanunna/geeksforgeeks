//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        // code here
        Stack<Integer> s1=new Stack<>();
        int max=0;
        int c=0;
        int last=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' ){
                s1.add(i);
                
            }
           else if(!s1.isEmpty() && s.charAt(s1.peek())=='('){
            s1.pop();
           }
           else {
            s1.add(i);
           }
                
        }
       //System.out.println(s1.size());
        while(!s1.isEmpty()){
          int t=s1.pop();
          int temp=last-t-1;
          max=(int)Math.max(temp,max);
          last=t;
        }
        return (int)Math.max(last,max);
    }
}