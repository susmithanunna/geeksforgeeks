//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        
        // Your code here
    //     String s=Integer.toBinaryString(n);
    //     //int decimal=Integer.valueOf(s);
    //   // System.out.println(s);
    //     long graycode=s.charAt(0)-'0';
    //   // System.out.println(graycode);
    //     int i=1;
    //     long prev=graycode;
    //     while(i<s.length()){
    //         long t=s.charAt(i)-'0';
    //         graycode=graycode*10+(prev^t);
    //         prev=prev^t;
    //         i++;
            
    //     }
    //     System.out.println(graycode);
    //     //String ans=Long.toString(graycode);
    //     // return Integer.parseInt(ans,2);
    //     return (int)graycode;
        //int binary=n^(n>>1);
        for(int mask=n>>1;mask!=0;mask=mask>>1){
            n=n^mask;
        }
        return n;
    }
       
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends