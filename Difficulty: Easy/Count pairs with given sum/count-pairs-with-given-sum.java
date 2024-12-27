//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        int n=arr.length;
        int c=0;
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<n;i++){
            if(h1.containsKey(target-arr[i])){
                c=c+h1.get(target-arr[i]);
            }
            if(h1.containsKey(arr[i])){
                h1.put(arr[i],h1.get(arr[i])+1);
            }
            else{
                h1.put(arr[i],1);
            }
            
        }
        return c;
    }
//     5 6 5 7 7 8
// 13
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.countPairs(nums, target));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends