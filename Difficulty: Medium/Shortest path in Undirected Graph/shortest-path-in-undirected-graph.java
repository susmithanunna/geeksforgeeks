//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q1=new LinkedList<>();
        q1.add(src);
        int dis[]=new int[n];
        int vis[]=new int[n];
        vis[src]=1;
        while(!q1.isEmpty()){
            int node=q1.remove();
            for(int it:adj.get(node)){
                if(vis[it]==0){
                    vis[it]=1;
                    dis[it]=dis[node]+1;
                    q1.add(it);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dis[i]==0 && src!=i){
                dis[i]=-1;
            }
        }
        return dis;
    }
}