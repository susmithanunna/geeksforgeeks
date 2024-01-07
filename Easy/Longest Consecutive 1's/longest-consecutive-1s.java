//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        String s1=Integer.toString(N,2);
        int c=0;
        int max_c=Integer.MIN_VALUE;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='1'){
                c++;
            }
            if(s1.charAt(i)!='1'){
                max_c=(int)Math.max(c,max_c);
                c=0;
            }
        }
        max_c=(int)Math.max(c,max_c);
        return max_c;
        
    }
}



//{ Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends