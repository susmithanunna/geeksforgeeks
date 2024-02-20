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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n1=image.length;
        int n2=image[0].length;
        int ans[][]=image;
        int a1=-1;
       
            a1=image[sr][sc];
            dfs(sr,sc,newColor,a1,ans,image);
         
        return ans;
    }
    public void dfs(int row,int col,int newColor,int a1,int ans[][],int image[][]){
        ans[row][col]=newColor;
        int n1=image.length;
        int n2=image[row].length;
        if((row-1>=0 && row-1<n1) && (col>=0 && col<n2)){
            if(image[row-1][col]==a1 && ans[row-1][col]!=newColor ){
                ans[row-1][col]=newColor;
                dfs(row-1,col,newColor,a1,ans,image);
            }
        }
        if((row>=0 && row<n1) && (col-1>=0 && col-1<n2)){
            if(image[row][col-1]==a1 && ans[row][col-1]!=newColor){
                 ans[row][col-1]=newColor;
                dfs(row,col-1,newColor,a1,ans,image);
            }
        }
        if((row>=0 && row<n1) && (col+1>=0 && col+1<n2)){
            if(image[row][col+1]==a1 && ans[row][col+1]!=newColor){
                 ans[row][col+1]=newColor;
                dfs(row,col+1,newColor,a1,ans,image);
            }
        }
       if((row+1>=0 && row+1<n1) && (col>=0 && col<n2)){
            if(image[row+1][col]==a1 && ans[row+1][col]!=newColor){
                 ans[row+1][col]=newColor;
                dfs(row+1,col,newColor,a1,ans,image);
            }
        }
        
    }
}