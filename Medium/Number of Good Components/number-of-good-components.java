//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int vr=edges[i][1];
            adj.get(u).add(vr);
            adj.get(vr).add(u);
        }
        boolean vis[]=new boolean[v+1];
        int ans=0;
        for(int i=1;i<=v;i++){
            if(vis[i]!=true){
                ArrayList<Integer> temp=new ArrayList<>();
                dfs(i,adj,vis,temp);
                int flag=1;
                for(int j:temp){
                    if(adj.get(j).size()!=temp.size()-1){
                        flag=0;
                        break;
                    }
                }
                if(flag==1){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void dfs(int vertex,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> temp){
        vis[vertex]=true;
        temp.add(vertex);
        for(int it:adj.get(vertex)){
            if(vis[it]!=true){
                 dfs(it,adj,vis,temp);
            }
           
        }
    }
}
