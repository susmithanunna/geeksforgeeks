//{ Driver Code Starts
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
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n1=board.length;
        int n2=board[0].length;
        int vis[][]=new int[n1][n2];
        int mrow[]={-1,+1,0,0};
        int mcol[]={0,0,-1,+1};
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(board[i][j]==word.charAt(0) && vis[i][j]==0){
                    if(dfs(i,j,vis,word,board,1,mrow,mcol)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int row,int col,int vis[][],String word,char board[][],int c,int mrow[],int mcol[]){
        vis[row][col]=1;
        int n1=board.length;
        int n2=board[0].length;
        if(c==word.length()){
            return true;
        }
        for(int i=0;i<4;i++){
            int r1=mrow[i]+row;
            int c1=mcol[i]+col;
            if(r1>=0 && c1>=0 && r1<n1 && c1<n2 && board[r1][c1]==word.charAt(c) && vis[r1][c1]==0){
                if(dfs(r1,c1,vis,word,board,c+1,mrow,mcol)){
                    return true;
                }
            }
        }
        vis[row][col]=0;    
        
        return false;
    }
}