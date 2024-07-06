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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        
        boolean vis[]=new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
        //         if(bfs(i,adj,vis,V)==false){
        //             return false;
        //         }
        //     }
        // }
        return bfs(0,adj,vis,V);
        //return true;
    }
     boolean bfs(int v,ArrayList<ArrayList<Integer>>adj,boolean vis[],int n){
        vis[v]=true;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        
        Queue<Integer> q1=new LinkedList<>();
         for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=1; //0->blue color
                q1.add(i);
            }
        //q1.add(v);
        while(!q1.isEmpty()){
            int u=q1.remove(); 
            for(int it:adj.get(u)){
                // if(i==u){
                //      //System.out.println("ans1");
                //     return false;
                // }
                if(color[it]==-1){
                    color[it]=1-color[u];
                    vis[it]=true;
                    q1.add(it);
                }
                else if(color[it]==color[u]){
                    //System.out.println("ans2");
                    return false;
                }
            }
        }
         }
        return true;
    }
}