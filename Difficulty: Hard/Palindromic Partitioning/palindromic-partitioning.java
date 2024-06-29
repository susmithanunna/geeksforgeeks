//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //static int dp[][]=new int[501][501];
    static int palindromicPartition(String s)
    {
        // code here
        int n=s.length();
       int dp[][]=new int[n+1][n+1];;
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        // int n=s.length();
        // 	String r=new StringBuilder(s).reverse().toString();
        // boolean p[][]=new boolean[n+1][n+1];
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=n;j++){
        //         if(i==0 || j==0){
        //             p[i][j]=true;
        //         }
        //         else if(j+1<=n && s.charAt(i-1)==r.charAt(j-1)){
        //             p[i][j]=p[i-1][j+1];
        //         }
        //         else{
        //             p[i][j]=false;
        //         }
        //     }
        //  }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         System.out.print(p[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return find(s,0,s.length()-1,dp);
        //return find(s,dp);
    }
    static int find(String s,int i,int j,int dp[][]){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int t1=0;
            int t2=0;
            if(dp[i][k]==-1){
                t1=find(s,i,k,dp);
            }
            else{
                t1=dp[i][k];
            }
            if(dp[k+1][j]==-1){
                t2=find(s,k+1,j,dp);
            }
            else{
                t2=dp[k+1][j];
            }
            ans=(int)Math.min(ans,(t1+t2+1));
        }
        return dp[i][j]=ans;
    }
    static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    // static int find(String s,boolean p[][]){
    //     int n=s.length();
    //     int dp[]=new int[n];
    //     for(int i=n-1;i>=0;i--){
    //         dp[i]=Integer.MAX_VALUE;
    //         if(p[i][n-1]==true){
    //             dp[i]=0;
    //         }
    //         else{
    //             for(int j=n-2;j>=i;j--){
    //                 if(p[i][j]==true){
    //                     dp[i]=(int)Math.min(dp[i],1+dp[j+1]);
    //                 }
    //             }
    //         }
          
    //     }
    //       return dp[0];
    // }
}