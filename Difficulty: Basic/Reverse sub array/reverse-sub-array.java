//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int l = Integer.parseInt(read.readLine());
            int r = Integer.parseInt(read.readLine());
            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            // int[] arr = new int[array1.size()];
            // int idx = 0;
            // for (int i : array1) arr[idx++] = i;

            v = new Solution().reverseSubArray(array1, l, r);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<Integer> reverseSubArray(ArrayList<Integer> arr, int l,
                                                     int r) {
        // code here
        int n=arr.size();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<l-1;i++){
            ans.add(arr.get(i));
        }
        for(int i=r-1;i>=l-1;i--){
            ans.add(arr.get(i));
        }
        for(int i=r;i<n;i++){
            ans.add(arr.get(i));
        }
        return ans;
    }
}