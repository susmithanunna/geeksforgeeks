//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            Solution obj = new Solution();
            
            System.out.println(obj.concatenatedString(s1,s2));
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        String ans="";
        Set<Character> s=new LinkedHashSet<>();
        for(int i=0;i<s1.length();i++){
            String t="";
            t=t+s1.charAt(i);
            if(!s2.contains(t)){
               ans=ans+s1.charAt(i);
            }
            
            
        }
        for(int i=0;i<s2.length();i++){
             String t="";
            t=t+s2.charAt(i);
             if(!s1.contains(t)){
               ans=ans+s2.charAt(i);
            }
        }
        if(ans.length()==0){
            return "-1";
        }
        
        return ans;
    }
}
