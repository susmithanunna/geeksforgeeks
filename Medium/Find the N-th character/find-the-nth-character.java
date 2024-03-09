//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        while(r!=0){
            String s1="";
            for(int i=0;i<n+1;i++){
                if(s.charAt(i)=='0'){
                    s1=s1+"01";
                }
                else{
                    s1=s1+"10";
                }
            }
            r--;
            s="";
            s=s+s1;
        }
        return s.charAt(n);
    }
}