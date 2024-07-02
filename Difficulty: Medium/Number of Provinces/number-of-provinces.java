//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
       
        boolean vis[]=new boolean[V];
        int c=0;
       for(int i=0;i<V;i++){
    
           if(!vis[i]){
               c++;
               dfs(i,adj,vis,V);
           }
       }
       return c;
    }
    public static void dfs(int v,ArrayList<ArrayList<Integer>> adj,boolean vis[],int V){
        vis[v]=true;
        for(int i=0;i<adj.get(v).size();i++){
                if(adj.get(v).get(i)==1){
                    if(!vis[i]){
                        dfs(i,adj,vis,V);
                    }
                }
            
            
        }
    }
};