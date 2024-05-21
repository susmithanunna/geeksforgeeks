//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        //idex of x such that arr[id1]==x || arr[id1]<x<arr[id1+1];
        int id1=binarysearch(arr,0,n-1,x);
        int id2=id1+1;
        
        if(arr[id1]==x){ //if arr[id1]==x for this point x is present in the array, then it need not be considered
            id1--;
        }
        int ans[]=new int[k];
        int c=0;
        while(id1>=0 && id2<n && c<k){
            if(x-arr[id1]<arr[id2]-x){
                ans[c]=arr[id1];
                id1--;
                c++;
            }
            else{
                ans[c]=arr[id2];
                c++;
                id2++;
            }
        }
        while(c<k && id1>=0){
            ans[c]=arr[id1];
            id1--;
            c++;
        }
        while(c<k && id2<n){
            ans[c]=arr[id2];
            id2++;
            c++;
        }
        return ans;
    }
    int binarysearch(int arr[],int low,int high,int x){
        if(arr[high]<=x){
            return high;
        }
        if(arr[low]>x){
            return low;
        }
        int mid=(low+high)/2;
        if(arr[mid]<=x && arr[mid+1]>x){
            return mid;
        }
        else if(arr[mid]<x){
            return binarysearch(arr,mid+1,high,x);
        }
        return binarysearch(arr,low,mid-1,x);
    }
}
