//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int i=0;
        int j=0;
        int m1=0;
        while(i>=0 && i<n && j>=0 && j<m){
            if(matrix[i][j]==1){
                matrix[i][j]=0;
                m1=(m1+1)%4;
            }
            if(m1==0){
                j++;
            }
            else if(m1==1){
                i++;
            }
            else if(m1==2){
                j--;
            }
            else{
                i--;
            }
            
        }
        if(m1==0){
            return new int[]{i,j-1};
        }
        else if(m1==1){
            return new int[]{i-1,j};
        }
        else if(m1==2){
            return new int[]{i,j+1};
        }
        return new int[]{i+1,j};
    }
}