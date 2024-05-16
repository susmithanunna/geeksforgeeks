//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    int ans;
    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int vis[]=new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int it[]:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
          ans=0;
        dfs(1,adj,vis);
        return ans;
        
    }
    public int dfs(int node,ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[node]=1;
        int cnt=0;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
               int t=dfs(it,adj,vis);
               if(t%2==0){
                   ans++;
               }
               else{
                   cnt=cnt+t;
               }
            }
        }
        return cnt+1;
    }
}
