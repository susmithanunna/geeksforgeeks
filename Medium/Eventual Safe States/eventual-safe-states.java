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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans=new ArrayList<>();
        int vis[]=new int[V];
        int pathVis[]=new int[V];
        int check[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,pathVis,check);
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    boolean dfs(int node,List<List<Integer>> adj,int vis[],int pathVis[],int check[]){
        vis[node]=1;
        pathVis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0 && pathVis[it]==0){
                if(dfs(it,adj,vis,pathVis,check)){
                    check[it]=0;
                    return true;
                }
            }
            else if(pathVis[it]==1){
                check[it]=0;
                return true;
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
        
    }
}
