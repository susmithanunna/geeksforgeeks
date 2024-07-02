//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<N;j++){
        //         ans[i][j]=graph[i][j];
        //     }
        // }
        for(int i=0;i<N;i++){
            //for(int j=0;j<N;j++){
                boolean vis[]=new boolean[N];
                ArrayList<Integer> a1=new ArrayList<>();
                dfs(i,graph,a1,vis,N);
                ArrayList<Integer> t1=new ArrayList<>(N);
                //Collections.fill(t1,0);
               // System.out.println(t1);
                for(int j=0;j<N;j++){
                    if(a1.contains(j)){
                        t1.add(1);
                    }
                    else{
                        t1.add(0);
                    }
                }
                ans.add(t1);
            //}
        }
        return ans;
    }
    static void dfs(int s,int graph[][],ArrayList<Integer> a1,boolean vis[],int n){
        vis[s]=true;
        a1.add(s);
        for(int i=0;i<n;i++){
            if(graph[s][i]==1 && !vis[i]){
                dfs(i,graph,a1,vis,n);
            }
        }
    }
}