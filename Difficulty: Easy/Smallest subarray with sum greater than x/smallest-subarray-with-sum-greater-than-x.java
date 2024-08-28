//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int n=arr.length;
        int sum=0;
       while(j<n){
            sum=sum+arr[j];
            if(sum>x){
                min=(int)Math.min(min,j-i+1);
                while(sum>x && i<n && i<=j){
                    min=(int)Math.min(min,j-i+1);
                    sum=sum-arr[i];
                    i++;
                }
                
            }
            j++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
