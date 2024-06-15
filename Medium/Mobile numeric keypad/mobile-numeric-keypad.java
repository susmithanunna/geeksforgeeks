//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        if(n==1){
            return 10;
        }
        int adj[][]=new int[10][];
        adj[0]=new int[]{0,8};
        adj[1]=new int[]{1,2,4};
        adj[2]=new int[]{1,2,3,5};
        adj[3]=new int[]{2,3,6};
        adj[4]=new int[]{1,4,5,7};
        adj[5]=new int[]{2,4,5,6,8};
        adj[6]=new int[]{3,5,6,9};
        adj[7]=new int[]{4,7,8};
        adj[8]=new int[]{5,7,8,9,0};
        adj[9]=new int[]{6,8,9};
        long count[]=new long[10];
        for(int i=0;i<10;i++){
            count[i]=1;
        }
        for(int i=2;i<=n;i++){
            long counttemp[]=new long[10];
            for(int j=0;j<10;j++){
                for(int k:adj[j]){
                    counttemp[k]+=count[j];
                }
            }
            for(int j=0;j<10;j++){
                count[j]=counttemp[j];
            }
        }
        long total=0;
        for(int i=0;i<10;i++){
            total+=count[i];
        }
        return total;
        
        
    }
}