//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
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
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        // PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->Integer.compare(y,x));
        // for(int i=0;i<k;i++){
        //     pq.add(arr[i]);
        // }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            max=(int)Math.max(max,arr[i]);
        }
        ans.add(max);

        for(int i=1;i<n-k+1;i++){
            if(max==arr[i-1]){
                max=0;
                for(int j=i;j<i+k && j<n;j++){
                    max=(int)Math.max(max,arr[j]);
                }
                ans.add(max);
            }
            else{
                max=(int)Math.max(max,arr[i+k-1]);
                ans.add(max);
            }
        }
        return ans;
        
    }
}