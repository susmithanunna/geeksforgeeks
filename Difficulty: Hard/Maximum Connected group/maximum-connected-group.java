//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int delrow[] = {-1, 1, 0,0};
     int delcol[] = {0, 0, -1, 1};
      public  boolean isValid(int n,int nrow,int ncol){
        return nrow>=0&&ncol>=0&&nrow<n&&ncol<n;
      }
    public int MaxConnection(int grid[][]) {
        int n=grid.length;
        // Your code here
        DisjoinSet dsu=new DisjoinSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int node=i*n+j;
                    for(int k=0;k<4;k++){
                        int r=i+delrow[k];
                        int c=j+delcol[k];
                        if(isValid(n,r,c) && grid[r][c]==1){
                            int t=i*n+j;
                            int adj=r*n+c;
                            dsu.unionBySize(node,adj);
                        }
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> h1=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int r=i+delrow[k];
                        int c=j+delcol[k];
                        if(r>=0 && r<n && c>=0 && c<n && grid[r][c]==1){
                            int t=r*n+c;
                            h1.add(dsu.findUPar(t));
                        }
                    }
                    int total_size=1;
                    for(int it:h1){
                        total_size+=dsu.size.get(it);
                    }
                    ans=(int)Math.max(ans,total_size);
                    
                }
                else{
                    ans=(int)Math.max(ans,dsu.size.get(i*n+j));
                }
            }
        }
        return ans;
        
       
    }
    
}
class DisjoinSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u==ulp_v) return ;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        
    }
}