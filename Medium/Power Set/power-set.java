//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> a=new ArrayList<>();
        int n=s.length();
        int num=(int)Math.pow(2,n);
        for(int i=0;i<=num;i++){
            String s1="";
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    s1=s1+s.charAt(j);
                }
            }
            if(s1.length()>=1){
                a.add(s1);
            }
            
        }
        Collections.sort(a);
        return a;
    }
}