//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        Stack<String> s1=new Stack<>();
        List<String> ans=new ArrayList<>();
        backTrack(0,0,n,s1,ans);
        return ans;
    }
    public void backTrack(int open ,int closed,int n,Stack<String> s1,List<String> ans){
        if(open==closed && closed==n){
            String s="";
            Iterator it=s1.iterator();
            while(it.hasNext()){
                s=s+it.next();
            }
            ans.add(s);
            s="";
        }
        if(open<n){
            s1.add("(");
            backTrack(open+1,closed,n,s1,ans);
            s1.pop();
        }
        if(closed<open){
            s1.add(")");
            backTrack(open,closed+1,n,s1,ans);
            s1.pop();
        }
    }
}