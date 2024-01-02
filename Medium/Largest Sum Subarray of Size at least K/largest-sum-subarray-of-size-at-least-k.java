//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long  k)
    {
        long ans=Long.MIN_VALUE;
         long sum=0;
         long prev_sum=0;
         int j=0;
        
        for(int i=0;i<k;i++){
            sum=sum+a[i];
        }
        ans=Math.max(sum,ans);
        for(int i=(int)k;i<n;i++){
            sum=sum+a[i];
            prev_sum=prev_sum+a[j];
            j++;
            ans=Math.max(sum,ans);
            if(prev_sum<0){
                sum=sum-prev_sum;
                ans=Math.max(sum,ans);
                prev_sum=0;
            }
           
        }
        return ans;
    }
}