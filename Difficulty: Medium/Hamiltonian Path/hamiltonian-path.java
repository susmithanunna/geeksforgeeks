//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
       int vis[]=new int[N+1];
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<=N;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<M;i++){
           adj.get(Edges.get(i).get(0)).add(Edges.get(i).get(1));
           adj.get(Edges.get(i).get(1)).add(Edges.get(i).get(0));
       }
       for(int i=1;i<=N;i++){
           if(vis[i]==0){
               int c=0;
              if(dfs(i,adj,vis,c,N)){
                  return true;
              }
               
            }
            
       }
       return false;
    }
    boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int vis[],int c,int N){
       
        if(c==N-1){
            return true;
        }
         vis[i]=1;
     
        for(int it:adj.get(i)){
            if(vis[it]==0)
            if(dfs(it,adj,vis,c+1,N)){
                return true;
            }
        }
        vis[i]=0;
        return false;
    }
    
} 