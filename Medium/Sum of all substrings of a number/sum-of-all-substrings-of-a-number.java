//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    long mod=(long)Math.pow(10,9)+7;
    int n=s.length();
    long prev=0;
    long curr=0;
    long ans=0;
    for(int i=0;i<n;i++){
        curr=((((i+1)*(s.charAt(i)-'0')))+(10*prev))%mod;
        ans=(ans+curr)%mod;
        prev=curr;
    }
    return ans;
    }
}