//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(i<=j && j<n){
            sum=sum+arr[j];
            if(sum==target){
                //System.out.println(sum+" "+i+" "+j);
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }
            while(sum>target && i<=j){
                sum=sum-arr[i];
                i++;
                if(sum==target){
                     //System.out.println(sum+" "+i+" "+j);
                    ans.add(i+1);
                    ans.add(j+1);
                    return ans;
                }
            }
            ///System.out.println(sum+" "+i+" "+j);
            j++;
        }
        ans.add(-1);
        return ans;
    }
}
