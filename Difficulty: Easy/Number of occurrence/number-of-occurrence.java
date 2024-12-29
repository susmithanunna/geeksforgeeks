//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
       int n=arr.length;
       int low=0;
       int high=n-1;
       int starting=-1;
       int ending=-1;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid]<=target){
              ending=mid;
              low=mid+1;
           }
           else{
               high=mid-1;
           }
       }
       low=0;
       high=n-1;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid]>=target){
               starting=mid;
               high=mid-1;
           }
           else{
               low=mid+1;
           }
       }
       if(starting==-1 || ending==-1){
           return 0;
       }
      // System.out.println(ending+" "+starting);
       return ending-starting+1;
    }
}
