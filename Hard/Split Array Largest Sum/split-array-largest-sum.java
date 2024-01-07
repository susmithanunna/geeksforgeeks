//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int l=0;
        int r=0;
        int ans=0;
        int mid=0;
        for(int i=0;i<arr.length;i++){
            r=r+arr[i];
            l=(int)Math.max(l,arr[i]);
        }
        while(l<=r){
            mid=(l+r)/2;
            int count=isPossible(arr,mid);
            if(count<=K){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    static int isPossible(int arr[],int max){
        int count=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=max){
                sum=sum+arr[i];
            }
            else{
                count++;
                sum=arr[i];
            }
        }
        return count;
    }
};