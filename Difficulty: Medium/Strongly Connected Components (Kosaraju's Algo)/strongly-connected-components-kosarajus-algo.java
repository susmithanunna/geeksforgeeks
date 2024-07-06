//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean vis[]=new boolean[V];
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs1(i,adj,s1,vis);
            }
        }
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<V;i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        int ans=0;
        boolean vis2[]=new boolean[V];
        while(!s1.isEmpty()){
            int u=s1.pop();
            if(!vis2[u]){
                ans++;
                dfs2(u,transpose,vis2);
            }
        }
        return ans;
        
        
    }
    public void dfs1(int v,ArrayList<ArrayList<Integer>> adj,Stack<Integer> s1,boolean vis[]){
    vis[v]=true;
    for(int it:adj.get(v)){
        if(!vis[it]){
            dfs1(it,adj,s1,vis);
        }
    }
    s1.add(v);
    }
    
    public void dfs2(int v,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[v]=true;
        for(int it:adj.get(v)){
            if(!vis[it]){
                dfs2(it,adj,vis);
            }
        }
    }
}
