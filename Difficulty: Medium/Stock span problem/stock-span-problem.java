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

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>(n);
       
        Stack<Integer> s1=new Stack<>();
          for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && arr[s1.peek()] <= arr[i]) {
                s1.pop();
            }
            int span = s1.isEmpty() ? (i + 1) : (i - s1.peek());
            ans.add(span);
            s1.push(i);
        }
        return ans;
        
        
    }
}