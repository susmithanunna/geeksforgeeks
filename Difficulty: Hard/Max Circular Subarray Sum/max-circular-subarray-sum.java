//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int tempmax=0;
        int min=Integer.MAX_VALUE;
        int tempmin=0;
        int sum=0;
        for(int i=0;i<n;i++){
            tempmax=tempmax+arr[i];
            max=(int)Math.max(tempmax,max);
            if(tempmax<0){
                tempmax=0;
            }
            
            tempmin=tempmin+arr[i];
            min=(int)Math.min(tempmin,min);
            if(tempmin>0){
                tempmin=0;
            }
            sum=sum+arr[i];
        }
        if(sum==tempmin){
            return max;
        }
        return (int)Math.max(max,sum-min);
    }
}
