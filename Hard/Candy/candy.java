//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        int candies_left[]=new int[N];
        int candies_right[]=new int[N];
        int j=N-2;
        candies_left[0]=1;
        candies_right[N-1]=1;
        for(int i=1;i<N;i++){
            if(ratings[i-1]<ratings[i]){
                candies_left[i]=candies_left[i-1]+1;
            }
            else{
                candies_left[i]=1;
            }
            if(ratings[j]>ratings[j+1]){
                candies_right[j]=candies_right[j+1]+1;
                j--;
            }
            else{
                candies_right[j]=1;
                j--;
            }
        }
        int ans=0;
        for(int i=0;i<N;i++){
            ans=ans+(int)Math.max(candies_left[i],candies_right[i]);
        }
        return ans;
    }
}
