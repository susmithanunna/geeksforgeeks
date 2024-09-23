//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n=arr.length;
       int a1[]=new int[n+1];
       for(int i=0;i<n;i++){
           a1[arr[i]]++;
       }
       int a=0;
       int b=0;
       for(int i=0;i<=n;i++){
           if(a1[i]==0){
               a=i;
           }
           if(a1[i]==2){
               b=i;
           }
       }
       return new int[]{b,a};
    }
}