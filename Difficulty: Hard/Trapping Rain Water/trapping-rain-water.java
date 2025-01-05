//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().trappingWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int trappingWater(int arr[]) {
        // code here
        int n=arr.length;
        int leftmax[]=new int[n];
        int rightmax[]=new int[n];
        leftmax[0]=arr[0];
        for(int i=1;i<n;i++){
            leftmax[i]=(int)Math.max(leftmax[i-1],arr[i]);
            
        }
        rightmax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=(int)Math.max(rightmax[i+1],arr[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans+(int)Math.min(leftmax[i],rightmax[i])-arr[i];
        }
        return ans;
    }
}
