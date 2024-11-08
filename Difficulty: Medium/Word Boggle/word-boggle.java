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
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
       int n=dictionary.length;
       int n1=board.length;
       int n2=board[0].length;
      ArrayList<String> a1=new ArrayList<>();
       for(int k=0;k<n;k++){
           int vis[][]=new int[n1][n2];
           for(int i=0;i<n1;i++){
               for(int j=0;j<n2;j++){
                   if(vis[i][j]==0 && board[i][j]==dictionary[k].charAt(0)){
                        if(dfs(i,j,vis,dictionary[k],board,1)){
                            if(!a1.contains(dictionary[k])){
                                a1.add(dictionary[k]);
                            }
                            
                        }
                   }
               }
           }
       }
       String ans[]=new String[a1.size()];
       for(int i=0;i<a1.size();i++){
           ans[i]=a1.get(i);
       }
       return ans;
       
    }
    public boolean dfs(int row,int col,int vis[][],String word,char board[][],int c){
        vis[row][col]=1;
        int n1=board.length;
        int n2=board[0].length;
        if(c==word.length()){
            return true;
        }
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
               int r1=i+row;
               int c1=j+col;
                if(r1>=0 && c1>=0 && r1<n1 && c1<n2 && board[r1][c1]==word.charAt(c) && vis[r1][c1]==0){
                    if(dfs(r1,c1,vis,word,board,c+1)){
                        return true;
                     }
                }
            }
        }
        vis[row][col]=0;    
        
        return false;
    }
}