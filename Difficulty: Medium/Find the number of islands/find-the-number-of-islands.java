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
     private final int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int numRows = grid.length;       // number of rows in the grid
        int numCols = grid[0].length;    // number of columns in the grid
        int islandCount = 0;
        
        // Iterate through every cell in the grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;  // New island found
                    dfsIterative(grid, i, j, numRows, numCols);  // Perform DFS iteratively
                }
            }
        }
        
        return islandCount;
    }
    
    // Iterative DFS function using a stack to avoid recursion limit issues
    private void dfsIterative(char[][] grid, int i, int j, int numRows, int numCols) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        grid[i][j] = '0';  // Mark the cell as visited
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currRow = current[0];
            int currCol = current[1];
            
            // Explore all 8 directions
            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                
                // Check if the new cell is valid and is land ('1')
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == '1') {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';  // Mark it as visited
                }
            }
        }
    }
    //  public int numIslands(char[][] grid) {
    //     // Code here
    //     int ans=0;
    //     int r[]={-1,0,1,0,-1,-1,1,1};
    //     int c[]={0,1,0,-1,-1,1,1,-1};
    //     int vis[][]=new int[grid.length][grid[0].length];
    //     for(int i=0;i<grid.length;i++){
    //         for(int j=0;j<grid[i].length;j++){
    //             if(vis[i][j]==0 && grid[i][j]=='1'){
    //                 ans++;
    //                 dfs(i,j,vis,grid,r,c);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public void dfs(int row,int col,int vis[][],char grid[][],int r[],int c[]){
    //     vis[row][col]=1;
    //     int n1=grid.length;
    //     int n2=grid[0].length;
    //     for(int i=0;i<8;i++){
    //             int delrow=row+r[i];
    //             int delcol=col+c[i];
    //             if(delrow>=0 && delrow<n1 && delcol>=0 && delcol<n2){
    //                 if(grid[delrow][delcol]=='1' && vis[delrow][delcol]==0){
    //                     dfs(delrow,delcol,vis,grid,r,c);
    //                 }
    //             }
            
    //     }
    // }
}