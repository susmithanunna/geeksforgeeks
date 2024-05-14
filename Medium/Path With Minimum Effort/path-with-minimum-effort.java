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

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int dist[][]=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(pq.size()!=0){
            Tuple temp=pq.remove();
            int diff=temp.distance;
            int r=temp.row;
            int c=temp.col;
            if(r==rows-1 && c==columns-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0 && newc>=0 && newr<rows && newc<columns){
                    int neweffort=(int)Math.max((int)Math.abs(heights[r][c]-heights[newr][newc]),diff);
                    if(neweffort<dist[newr][newc]){
                        dist[newr][newc]=neweffort;
                        pq.add(new Tuple(neweffort,newr,newc));
                    }
                }
            }
        }
        return -1;
    }
    
}
class Tuple{
    int row;
    int col;
    int distance;
    public Tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
