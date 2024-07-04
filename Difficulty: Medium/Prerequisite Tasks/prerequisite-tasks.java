//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean path[]=new boolean[N];
        boolean vis[]=new boolean[N];
        for(int i=0;i<N;i++){
            if(!vis[i]){
                if(dfs(i,path,vis,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int v,boolean path[],boolean vis[],ArrayList<ArrayList<Integer>> adj){
        vis[v]=true;
        path[v]=true;
        for(int it:adj.get(v)){
            if(!vis[it]){
                if(dfs(it,path,vis,adj)){
                    return true;
                }
            }
            if(path[it]){
                return true;
            }
        }
        path[v]=false;
        return false;
    }
    
}