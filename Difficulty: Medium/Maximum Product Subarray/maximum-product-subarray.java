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
        int left_prod=1;
        int right_prod=1;
        for(int i=0;i<n;i++){
            left_prod=left_prod*arr[i];
            max=(int)Math.max(max,left_prod);
            right_prod=right_prod*arr[n-i-1];//traversing from back
            max=(int)Math.max(max,right_prod);
             if(left_prod==0){
                left_prod=1;
            }
            if(right_prod==0){
                right_prod=1;
            }
        }
        return max;
    }
}