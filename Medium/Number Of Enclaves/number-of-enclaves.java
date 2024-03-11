//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int ans=0;
        int n1=grid.length;
        int n2=grid[0].length;
        int vis[][]=new int[n1][n2];
        int delrow[]={-1,0,0,+1};
        int delcol[]={0,-1,+1,0};
        for(int i=0;i<n1;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,vis,grid,delrow,delcol);
            }
            if(vis[i][n2-1]==0 && grid[i][n2-1]==1){
                dfs(i,n2-1,vis,grid,delrow,delcol);
            }
        }
        for(int j=0;j<n2;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,vis,grid,delrow,delcol);
            }
            if(vis[n1-1][j]==0 && grid[n1-1][j]==1){
                dfs(n1-1,j,vis,grid,delrow,delcol);
            }
        }
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int row,int col,int vis[][],int grid[][],int delrow[],int delcol[]){
        vis[row][col]=1;
        int n1=grid.length;
        int n2=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=delrow[i]+row;
            int ncol=delcol[i]+col;
            if(nrow>=0 && nrow<n1 && ncol>=0 && ncol<n2 && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,delrow,delcol);
            }
        }
    }
}