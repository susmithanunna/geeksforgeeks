//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int delrow[]={-1,1,0,0};
        int delcol[]={0,0,-1,1};
        Set<List<Pair>> s1=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    List<Pair> l1=new ArrayList<>();
                    dfs(i,j,grid,vis,delrow,delcol,l1,i,j);
                    s1.add(l1);
                }
            }
        }
        return s1.size();
    }
    public void dfs(int r,int c,int grid[][],int vis[][],int delrow[],int delcol[],List<Pair> l1,int br,int bc){
        vis[r][c]=1;
        l1.add(new Pair(r - br, c - bc));
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nr=r+delrow[i];
            int nc=c+delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                
                dfs(nr,nc,grid,vis,delrow,delcol,l1,br,bc);
            }
        }
    }
}
class Pair{
    int f;
    int s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return f == pair.f && s == pair.s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(f, s);
    }
}
