//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int vis[][]=new int[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                   c++;
                   dfs(i,j,vis,grid);
                }
            }
        }
        return c;
    }
    public void dfs(int row,int col,int vis[][],char grid[][]){
        int n1=grid.length;
        int n2=grid[0].length;
        vis[row][col]=1;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int delrow=row+i;
                /*(row-1,col-1),(row-1,col),(row-1,col+1),
                  (row,col-1),                (row,col+1),
                  (row+1,col-1),(row+1,col),(row+1,col+!)*/
                int delcol=col+j;
                if((delrow>=0 && delrow<n1) && (delcol>=0 && delcol<n2)){
                   if(grid[delrow][delcol]=='1' && vis[delrow][delcol]==0){
                        dfs(delrow,delcol,vis,grid);
                   }
                }
            }
        }
    }
}