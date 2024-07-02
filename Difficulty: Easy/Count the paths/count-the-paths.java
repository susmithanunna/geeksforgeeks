//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for(int i = 0; i < m; i++){
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        boolean vis[]=new boolean[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            //adj.get(v).add(u);
        }
        // for(int i=0;i<adj.size();i++){
        //     for(int j=0;j<adj.get(i).size();j++){
        //         System.out.print(adj.get(i).get(j)+" ");
        //     }
        //     System.out.println();
        // }
        if(s==d){
            return 1;
        }
        return dfs(s,d,vis,adj);
        //return c;
    }
    public int  dfs(int s,int d,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> s1=new Stack<>();
        s1.add(s);
        int c=0;
        while(!s1.isEmpty()){
             int t=s1.pop();
             //vis[t]=true;
             //System.out.println(t);
            for(int it:adj.get(t)){
                 //if(!vis[it]){
                    if(it==d){
                    //System.out.println("hi");
                        c++;
                    }
                    s1.add(it);
                 //}
            }
        } 
        return c;
    }
    
}