//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int dp[][]=new int[N][4];
        dp[0][0]=(int)Math.max(points[0][1],points[0][2]);
        dp[0][1]=(int)Math.max(points[0][0],points[0][2]);
        dp[0][2]=(int)Math.max(points[0][0],points[0][1]);
        int t=(int)Math.max(points[0][0],points[0][1]);
        dp[0][3]=(int)Math.max(t,points[0][2]);
        for(int i=1;i<N;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=0;
                for(int k=0;k<3;k++){
                    if(j!=k){
                       int point=points[i][k]+dp[i-1][k]; 
                       dp[i][j]=(int)Math.max(dp[i][j],point);
                    }
                    
                }
            }
        }
        return dp[N-1][3];
    }
}