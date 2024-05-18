//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        int sum=0;
        int max=0;
        int currstart=0;
        int maxend=-1;
        int maxstart=-1;
        int curr_sum=0;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
           if(a[i]>=0){
               curr_sum+=a[i];
               if(max<curr_sum || ((curr_sum==max) && (i-currstart>maxend-maxstart)) ){
                   maxstart=currstart;
                   max=curr_sum;
                   maxend=i;
               }
           }
           else{
               curr_sum=0;
               currstart=i+1;
           }
            
        }
        if(maxend==-1){
            return ans;
        }
        for(int i=maxstart;i<=maxend;i++){
            ans.add(a[i]);
        }
        return ans;
    }
}