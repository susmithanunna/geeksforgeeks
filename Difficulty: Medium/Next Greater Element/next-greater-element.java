//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        Stack<Integer> s1=new Stack<>();
        s1.push(arr[n-1]);
        ans.add(-1);
        for(int i=n-2;i>=0;i--){
            while(!s1.isEmpty() && s1.peek()<=arr[i]){
               s1.pop();
            }
            if(!s1.isEmpty() && s1.peek()>arr[i]){
                ans.add(s1.peek());
                s1.push(arr[i]);
            }
            
            else {
                ans.add(-1);
                s1.push(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}