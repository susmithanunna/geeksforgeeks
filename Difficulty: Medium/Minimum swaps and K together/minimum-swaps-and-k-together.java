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
            int ans = sln.minSwap(a, k);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Complete the function
        int n=arr.length;
        int maxtogether=0;
        int req=0;
        int c=0;
        int index=-1;
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                req++;
                c++;
            }
            else{
                maxtogether=(int)Math.max(maxtogether,req);
                req=0;
            }
        }
         maxtogether=(int)Math.max(maxtogether,req);
        return c-maxtogether;
    }
}
