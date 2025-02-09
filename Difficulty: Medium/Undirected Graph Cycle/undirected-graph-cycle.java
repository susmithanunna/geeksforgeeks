//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n=adj.size();
          int vis[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(bfs(adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,int i,int vis[]){
        Queue<Pair> q1=new LinkedList<>();
        q1.add(new Pair(i,-1));
        vis[i]=1;
        while(!q1.isEmpty()){
            Pair p=q1.remove();
            int node=p.node;
            int parent=p.parent;
            for(int it:adj.get(node)){
                if(vis[it]==0){
                    q1.add(new Pair(it,node));
                    vis[it]=1;
                }
                else if(parent!=it){
                    return true;
                }
            }
        }
        return false;
    }
}
class Pair{
    int node;
    int parent;
    public Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}