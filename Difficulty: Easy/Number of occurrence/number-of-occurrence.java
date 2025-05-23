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
       int starting=0;
       int ending=n-1;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid]>=target){
               ending=mid;
               high=mid-1;
           }
           else{
               low=mid+1;
           }
       }
       low=0;
       high=n-1;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid]<=target){
               starting=mid;
               low=mid+1;
           }
           else{
               high=mid-1;
           }
       }
       //System.out.println(starting+" "+ending);
       if(arr[starting]!=target || arr[ending]!=target){
           return 0;
       }
       return starting-ending+1;
    }
}
