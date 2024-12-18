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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(n<k){
            return -1;
        }
       // Arrays.sort(arr);
       int max=Integer.MIN_VALUE;
       int sum=0;
       for(int i=0;i<n;i++){
           sum=sum+arr[i];
           max=(int)Math.max(max,arr[i]);
       }
       int ans=-1;
       int low=max;
       
       int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(arr,mid,k)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean find(int arr[],int max,int k){
        int sum=0;
        int c=1;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=max){
                sum=sum+arr[i];
            }
            else{
                sum=arr[i];
                c++;
            }
            if(c>k){
                return false;
            }
            
        }
        if(c<=k){
            return true;
        }
        return false;
    }
}