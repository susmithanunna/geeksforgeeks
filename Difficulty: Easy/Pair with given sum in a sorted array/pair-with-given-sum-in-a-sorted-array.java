//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
    //     int n=arr.length;
    //   int i=0;
    //   int j=n-1;
    //   int ans=0;
    //      while(i<j){
    //          if(arr[i]+arr[j]==target){
    //              //System.out.println(arr[i]+" "+arr[j]+" "+i+" "+j);
                
    //              if(arr[i]==arr[j]){
    //                  int t=j-i;
    //                      ans=ans+(t*(t+1))/2;
    //                      break;
    //              }
    //              else{
    //                  ans++;
    //                  while(i+1<j && arr[i+1]+arr[j]==target){
    //                   i++;
    //                   ans++;
    //                  }
    //                  while(j-1>i && arr[j-1]+arr[i]==target){
    //                      j--;
    //                      ans++;
    //                  }
    //              }
                 
    //              j--;
    //          }
    //          else if(arr[i]+arr[j]>target){
    //              j--;
    //          }
    //          else{
    //              i++;
    //          }
    //      }
    //      return ans;
     int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                if(arr[left]==arr[right]){
                    int t=right-left;
                    count=count+(t*(t+1))/2;
                    break;
                }
                
                int leftVal = arr[left];
                int rightVal = arr[right];
                int leftCount = 1, rightCount = 1;

                while (left + 1 < right && arr[left] == arr[left + 1]) {
                    leftCount++;
                    left++;
                }

                // Count duplicates for the right value
                while (right - 1 > left && arr[right] == arr[right - 1]) {
                    rightCount++;
                    right--;
                }

                // Add all combinations of these duplicates
                count += leftCount * rightCount;

                // Move past the current values
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends