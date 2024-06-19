//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        int r=0;
	    int l=0;
	    int sum=0;
	    int min=Integer.MAX_VALUE;
	    while(r<n){
	        if(sum<=x){
	            sum=sum+a[r];
	            r++;
	        }
	        else if(sum>x){
	            min=(int)Math.min(r-l,min);
	            while(sum>x){
	                sum=sum-a[l];
	                l++;
	                if(sum>x)
	                min=(int)Math.min(r-l,min);
	            }
	        }
	    }
	    //System.out.println(sum);
	    if(sum>x){
	        min=(int)Math.min(r-l,min);
	            while(sum>x){
	                sum=sum-a[l];
	                l++;
	                if(sum>x)
	                min=(int)Math.min(r-l,min);
	            }
	    }
	    if(min==Integer.MAX_VALUE){
	        return 0;
	    }
	    return min;
    }
}

