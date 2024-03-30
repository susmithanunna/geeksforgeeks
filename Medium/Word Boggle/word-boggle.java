//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   // public int vis[][];
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        ArrayList<String> ans=new ArrayList<>();
        int n1=board.length;
        int n2=board[0].length;
        // vis=new int[n1][n2];
        for(String st:dictionary){
            boolean found=false;
            for(int i=0;i<n1;i++){
                for(int j=0;j<n2;j++){
                     if(st.length()==1 && n1==1 && n2==1 && board[i][j]==st.charAt(0)){
                        ans.add(st);
                        found=true;
                    }
                    if(board[i][j]==st.charAt(0)){
                        if(dfs(i,j,st,board,0,new boolean[n1][n2])==true){
                            if(!ans.contains(st)){
                              ans.add(st);
                            }
                            found=true;
                        }
                    }
                   
                }
                if(found){
                    break;
                }
            }
        }
        String a1[]=new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            a1[i]=ans.get(i);
        }
        return a1;
    }
    public boolean dfs(int row,int col,String s,char board[][],int c,boolean vis[][]){
        int n1=board.length;
        int n2=board[0].length;
        if(c==s.length()){
            return true;
        }
        if(row<0 || row>=n1 || col<0 || col>=n2 ||vis[row][col]==true || board[row][col]!=s.charAt(c) ){
            return false;
        }
        vis[row][col]=true;
        boolean result=false;
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
        for(int i=0;i<8;i++){
                int delrow=row+dx[i];
                int delcol=col+dy[i];
                if( delrow>=0 && delrow<n1 && delcol>=0 && delcol<n2){
                       if(dfs(delrow,delcol,s,board,c+1,vis)){
                           //System.out.println(s);
                           result=true;
                       }
                }
        }
        vis[row][col]=false;
        return result;
    }
}