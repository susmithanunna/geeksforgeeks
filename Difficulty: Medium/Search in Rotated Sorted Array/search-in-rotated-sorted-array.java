//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
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

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int n=arr.length;
        int minindex=-1;
        if(arr[0]<arr[1] && arr[0]<arr[n-1]){
            minindex=0;
        }
        for(int i=1;i<n;i++){
            if(i+1<n && arr[i-1]>=arr[i] && arr[i+1]>=arr[i]){
                minindex=i;
            }
        }
        if(arr[n-1]<=arr[n-2] && arr[n-1]<arr[0]){
            minindex=n-1;
        }
      //  System.out.println(minindex);
        int t1=binarysearch(arr,key,0,minindex-1);
       int t2=binarysearch(arr,key,minindex,n-1);
        return t1==-1?t2:t1;
    }
    public int binarysearch(int arr[],int key,int low,int high){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]<key){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}