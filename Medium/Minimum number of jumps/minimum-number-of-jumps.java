//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr, size));
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr, int n) {
        // your code here
        int jumps=0;
        int far=0;
        if(n==1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }
        int currjumpend=0;
        for(int i=0;i<n-1;i++){
            far=(int)Math.max(far,i+arr[i]);
            if(i==currjumpend){
                currjumpend=far;
                jumps++;
            }
            if(currjumpend>=n-1){
                return jumps;
            }
        }
        return -1;
    }
}