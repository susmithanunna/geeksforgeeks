//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        //Collections.sort(Arr);
        long sum=0;
        int c=0;
        long max=Integer.MAX_VALUE;
        for(int i=0;i<K;i++){
            sum=sum+Arr.get(i);
        }
        max=sum;
        //System.out.println(max);
        for(int i=K;i<N;i++){
            sum=sum-Arr.get(i-K);
            sum=sum+Arr.get(i);
            max=(long)Math.max(max,sum);
            
        }
       
        return max;
        /*The code is sorting the array instead of finding the maximum sum of subarrays.
        To fix it, you need to implement a sliding window approach to find the maximum sum.
        Start by calculating the sum of the first K elements. Then, iterate through the array 
        and subtract the previous element and add the current element to the sum. 
        Update the maximum sum if the current sum is greater. Finally, return the maximum sum.*/
    }
}