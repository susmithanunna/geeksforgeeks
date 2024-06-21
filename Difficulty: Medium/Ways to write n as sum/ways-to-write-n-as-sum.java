//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{

  public static void main (String[] args)  {
     Scanner s=new Scanner(System.in);
     int t=s.nextInt();
     while(t-->0){
         int n=s.nextInt();
         Solution obj = new Solution();
         System.out.println(obj.countWays(n));
     }

   }
}

// } Driver Code Ends




class Solution
{
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n)
    {
    
         // your code here
         int dp[]=new int[n+1];
         dp[0]=1;
         int mod=(int)Math.pow(10,9)+7;
         for(int i=1;i<n;i++){
             for(int j=i;j<=n;j++){
                 int t=j-i;
                 dp[j]=(dp[j]+dp[t])%mod;
             }
         }
         return dp[n];
        
    }
}
