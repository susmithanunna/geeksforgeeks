//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String s = sc.next();
            
            int answer = new Solution().isRotatedPalindrome(s);
    		System.out.println(answer);
        }
        
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    int isRotatedPalindrome(String s)
    {
        // Your Code Here 
        String s1="";
        String s2="";
        if(isPalindrome(s)){
            return 1;
        }
        for(int i=1;i<s.length();i++){
           s1="";
           s2="";
           s1=s1+s.substring(0,i);
           s2=s2+s.substring(i,s.length());
           String s3=s2+s1;
           if(isPalindrome(s3)){
               return 1;
           }
        }
        return 0;
    }
    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}