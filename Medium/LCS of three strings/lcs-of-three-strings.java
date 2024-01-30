//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
     int dp[][][]=new int[n1+1][n2+1][n3+1];
     for(int i=0;i<=n1;i++){
         for(int j=0;j<=n2;j++){
             for(int k=0;k<=n3;k++){
                 dp[i][j][k]=0;
             }
         }
     }
     for(int i=n1-1;i>=0;i--){
         for(int j=n2-1;j>=0;j--){
             for(int k=n3-1;k>=0;k--){
                 if(A.charAt(i)==B.charAt(j) && B.charAt(j)==C.charAt(k)){
                     dp[i][j][k]=1+dp[i+1][j+1][k+1];
                 }
                 else{
                     int t=(int)Math.max(dp[i][j][k+1],dp[i][j+1][k]);
                     dp[i][j][k]=(int)Math.max(t,dp[i+1][j][k]);
                 }
             }
         }
     }
     return dp[0][0][0];
        
    }
}