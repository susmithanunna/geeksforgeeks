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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int n=grid.length;
        int cost[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Tuple(0,0,grid[0][0]));
        cost[0][0]=grid[0][0];
       while (!pq.isEmpty()) {
    Tuple t = pq.remove();
    int row = t.row;
    int col = t.col;
    int oldCost = t.cost;

    for (int[] direction : directions) {
        int nrow = row + direction[0];
        int ncol = col + direction[1];

        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
            int newCost = grid[nrow][ncol] + oldCost;
            if (cost[nrow][ncol] > newCost) {
                cost[nrow][ncol] = newCost;
                pq.add(new Tuple(nrow, ncol, newCost));
            }
        }
    }
}

return cost[n - 1][n - 1];
       // return cost[n-1][n-1];
    }
    
}
class Tuple{
        int row;
        int col;
        int cost;
        Tuple(int root,int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
}