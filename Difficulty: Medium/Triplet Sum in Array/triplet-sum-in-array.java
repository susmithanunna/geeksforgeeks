//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            boolean ans =
                ob.hasTripletSum(nums, target); // Call the function and store result
            System.out.println(ans ? "true" : "false"); // Output the result
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean hasTripletSum(int arr[], int target) {
        // Your code Here
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int s=i+1;
            int e=n-1;
            while(s<e){
                int t=arr[i]+arr[s]+arr[e];
                if(t==target){
                    return true;
                }
                else if(t>target){
                    e--;
                }
                else{
                    s++;
                }
            }
        }
        return false;
        
    }
}
