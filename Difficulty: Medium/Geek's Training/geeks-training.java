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
        dp[0][2]=(int)Math.max(points[0][1],points[0][0]);
        dp[0][3]=(int)Math.max(dp[0][0],(int)Math.max(points[0][1],points[0][2]));
        for(int day=1;day<N;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                for(int task=0;task<3;task++){
                    if(last!=task){
                       int point=points[day][task]+dp[day-1][task];
                       dp[day][last]=(int)Math.max(point,dp[day][last]);
                    }
                }
            }
        }
        return dp[N-1][3];
        
    }
}