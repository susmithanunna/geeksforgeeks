//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        boolean a1=dfs(0,-1,adj,vis);
        for(int i=0;i<n;i++){
            if(!vis[i]){
               return false;
            }
        }
        return a1;
        
    }
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                if(!dfs(it,node,adj,vis)){
                    return false;
                }
            }
            else if(it!=parent){
                return false;
            }
        }
        return true;
    }
}

