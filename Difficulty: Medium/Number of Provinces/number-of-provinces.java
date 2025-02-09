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
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int vis[]=new int[V];
        int c=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                c++;
                dfs(adj,vis,i,V);
            }
        }
        return c;
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj,int vis[],int node,int V){
        vis[node]=1;
        for(int i=0;i<V;i++){
            if(adj.get(node).get(i)==1 && vis[i]==0){
                dfs(adj,vis,i,V);
            }
        }
    }
};