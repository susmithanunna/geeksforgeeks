//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n=mat.length;
        int ans[]=new int[n*n];
        int c=0;
        int row=0;
        int col=0;
        while(c<n*n){
            //diagonally upward
            while(row>=0 && col<n){
                if(row>=0 && row<n && col>=0 && col<n){
                    ans[c]=mat[row][col];
                    c++;
                    mat[row][col]=(int)1e9;
                }
                row--;
                col++;
            }
            if(c==n*n){
                break;
            }
            row=(int)Math.max(row+1,0);
            col=(int)Math.min(col,n-1);
            while(mat[row][col]==(int)1e9){
                row++;
            }
            //diagonally downward
            while(row<n && col>=0){
                if(row>=0 && row<n && col>=0 && col<n){
                    ans[c]=mat[row][col];
                    c++;
                    mat[row][col]=(int)1e9;
                }
                row++;
                col--;
            }
            if(c==n*n){
                break;
            }
            row=(int)Math.min(row,n-1);
            col=(int)Math.max(col+1,0);
            while(mat[row][col]==(int)1e9){
                col++;
            }
            
        }
        return ans;
    }
}