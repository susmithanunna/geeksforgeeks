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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.is_palindrome(n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        int n1=n;
	    int j=(int)Math.floor(Math.log10(n1)+1)-1;
	    int i=1;
	     while(n1!=0){
	        int t1=n1%10;
	        n1=n1/10;
	        j=(int)Math.floor(Math.log10(n1)+1)-1;
	        if(n1==0){
	           return "Yes";
	        }
	        int t2=n1/(int)Math.pow(10,j);
	        if(t1!=t2){
	            return "No";
	        }
	        n1=n1%(int)Math.pow(10,j);
	        i++;
	    }
	    return "Yes";
    }
}