//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // int n=mat.length;
        // int m=mat[0].length;
        // boolean row=false;
        // boolean col=false;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(mat[i][j]==0){
        //             if(i==0){
        //                 row=true;
        //             }
        //             if(j==0){
        //                 col=true;
        //             }
        //             mat[i][0]=0;
        //             mat[0][j]=0;
        //         }
        //     }
        // }
        // for(int i=1;i<n;i++){
        //     for(int j=1;j<m;j++){
        //         if(mat[i][0]==0 || mat[0][j]==0){
        //             mat[i][j]=0;
        //         }
        //     }
        // }
        
        // if(row==true){
        //     for(int i=0;i<m;i++){
        //         mat[0][i]=0;
        //     }
        // }
        //  if(col==true){
        //     for(int i=0;i<n;i++){
        //         mat[i][0]=0;
        //     }
        // }
             
        Set<Integer> r=new HashSet<>();
        Set<Integer> c=new HashSet<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
        
               if(mat[i][j]==0){
                   r.add(i);
                   c.add(j);
                   int k=i;
                    while(k>=0){
                       mat[k][j]=0;
                       k--;
                   }
                   k=j;
                   while(k>=0){
                       mat[i][k]=0;
                       k--;
                   }
                   
               } 
               
               if(r.contains(i) || c.contains(j)){
                   mat[i][j]=0;
               }
               
            }
        }
//       4
// 4
// -5 2 3 0
// -2 -5 -2 -5
// -1 4 4 -2
// 2 5 1 4
    }
}