//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        String s="";
        find(mat,0,0,s,ans);
        return ans;
    }
    public void find(int mat[][],int row,int col,String s,ArrayList<String> ans){
        if(row>=mat.length|| col>=mat[0].length || row<0 || col<0 || mat[row][col]==0){
            return;
        }
        if(row==mat.length-1 && col==mat[0].length-1){
            ans.add(new String(s));
           return;
            
        }
        mat[row][col]=0;
        find(mat,row-1,col,s+"U",ans);
        find(mat,row+1,col,s+"D",ans);
        find(mat,row,col-1,s+"L",ans);
        find(mat,row,col+1,s+"R",ans);
        mat[row][col]=1;
    }
}