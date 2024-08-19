//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=(int)Math.max(arr[i],max);
        }
        //System.out.println("max "+max);
        int a1[]=new int[max+1];
        for(int i=0;i<arr.length;i++){
            a1[arr[i]]=1+a1[arr[i]];
        }
        
        for(int i=1;i<=max;i++){
            //System.out.print(a1[i]+" ");
            if(k==0){
                return i-1;
            }
            else{
                if(a1[i]!=0){
                    k--;
                }
            }
        }
        if(k==0){
            return max;
        }
        return -1;
        
    }
}
