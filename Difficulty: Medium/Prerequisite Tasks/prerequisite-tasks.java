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
		
System.out.println("~");
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
        int vis[]=new int[N];
        int pathvis[]=new int[N];
        for(int i=0;i<P;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(u).add(v);
          
        }
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                if(bfs(i,adj,vis,pathvis)){
                    return false;
                }
            }
        }
        
        return true;
    }
    public boolean bfs(int i,ArrayList<ArrayList<Integer>> adj,int vis[],int pathvis[]){
        vis[i]=1;
   
    pathvis[i]=1;
    for(int it:adj.get(i)){
        if(vis[it]==0){
            if(bfs(it,adj,vis,pathvis)){
                return true;
            }
        }
        else if(pathvis[it]==1){
            return true;
        }
    }
    pathvis[i]=0;
    return false;
        
    }
    
}
class Pair{
    int node;
    int parent;
    Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}