//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
       int max=Integer.MIN_VALUE;
       int leftprod=1;
       int rightprod=1;
       for(int i=0;i<n;i++){
           leftprod=leftprod*arr[i];
           rightprod=rightprod*arr[n-i-1];
           max=(int)Math.max((int)Math.max(leftprod,rightprod),max);
           if(leftprod==0){
               leftprod=1;
           }
           if(rightprod==0){
               rightprod=1;
           }
       }
       return max;
    }
}