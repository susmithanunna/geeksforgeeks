//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
   
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       return find(arr,0,-1,dp);
       
    }
    public static int find(int arr[],int index,int previndex,int dp[][]){
        int n=arr.length;
        
        if(index==n){
            return 0;
        }
        if(dp[index][previndex+1]!=-1){
            return dp[index][previndex+1];
        }
        int i=index;
        int take=0;
        if(previndex==-1 || arr[previndex]<arr[index]){
            take=1+find(arr,index+1,i,dp);
        }
       
        int nottake=find(arr,index+1,previndex,dp);
        dp[index][previndex+1]=Math.max(take,nottake);
        return dp[index][previndex+1];
    }
}
//22 34 36 30

//   0 1 2 3 4
// 0  0 0 0 0 0
// 1  0 1 
// 2  0 1
// 3  0 1
// 4  0 1