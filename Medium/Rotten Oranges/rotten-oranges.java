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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int v;
    Pair(int _row,int _col,int _v){
        this.row=_row;
        this.col=_col;
        this.v=_v;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n1=grid.length;
        int n2=grid[0].length;
        int vis[][]=new int[n1][n2];
        int cf=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(grid[i][j]==1){
                    cf++;
                }
               if(grid[i][j]==2){
                   q.add(new Pair(i,j,0));
                vis[i][j]=2;
               }
               else{
                   vis[i][j]=0;
               }
            }
        }
        //System.out.println("cf:"+cf);
        int c1=0;
        int val=0; 
        int delrow[]={-1,+1,0,0};
        int delcol[]={0,0,-1,+1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int value=q.peek().v;
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow=delrow[i]+r;
                int ncol=delcol[i]+c;
                val=(int)Math.max(val,value);
                if((nrow>=0 && nrow<n1) && (ncol>=0 && ncol<n2)){
                    if(vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                        vis[nrow][ncol]=2;
                        q.add(new Pair(nrow,ncol,value+1));
                        c1++;
                    }
                }
            }
        }
        //System.out.println("c1:"+c1);
        if(c1!=cf){
            return -1;
        }
        return val;
        
    }
    
}