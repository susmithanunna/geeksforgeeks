//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        // HashSet<Integer> s1=new HashSet<>();
        // int c=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         s1.add(mat2[i][j]);
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(s1.contains(x-mat1[i][j])){
        //             c++;
        //         }
        //     }
        // }
        // return c;
        int ans=0;
        int i=0;
        int j=n-1;
        int c1=0;
        int c2=n-1;
        while(i<n && j>=0){
            int val=mat1[i][c1]+mat2[j][c2];
            if(val==x){
                ans++;
                c1++;
                c2--;
            }
            else if(val<x){
                c1++;
            }
            else{
                c2--;
            }
            if(c1==n){
                c1=0;
                i++;
            }
            if(c2==-1){
                c2=n-1;
                j--;
            }
        }
        return ans;
    }
}