//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        Queue<Pair> q1=new LinkedList<>();
        int distance[]=new int[adj.size()];
        q1.add(new Pair(src,0));
        Arrays.fill(distance,-1);
        distance[src]=0;
        while(!q1.isEmpty()){
            Pair p1=q1.remove();
            int node=p1.node;
            int dis=p1.dis;
            for(int it:adj.get(node)){
                if(distance[it]==-1){
                    q1.add(new Pair(it,dis+1));
                    distance[it]=dis+1;
                }
            }
        }
        return distance;
    }
}
class Pair{
    int node;
    int dis;
    public Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
