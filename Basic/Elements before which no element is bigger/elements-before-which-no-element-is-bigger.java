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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countElements(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static long countElements(long arr[], long n) 
    {
        // Your code goes here
        int c=1;
        long max=Long.MIN_VALUE;
        max=arr[0];
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                c++;
                max=arr[i];
            }
        }
        return c;
    }
}
