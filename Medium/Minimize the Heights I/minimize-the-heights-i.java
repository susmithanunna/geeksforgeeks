//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);                                   //[a,c,d,b]
        int max=arr[n-1];                                   //the min diff is lied bt consetive numbers
        int min=arr[0];                                     //max=max(c+k,b-k);
        int ans=max-min;                                    //min=min(a+k,d-k);
        for(int i=1;i<n;i++){
            max=(int)Math.max(arr[i-1]+k,arr[n-1]-k);
            min=(int)Math.min(arr[i]-k,arr[0]+k);
            ans=(int)Math.min(ans,max-min);
        }
        return ans;
    }
}
