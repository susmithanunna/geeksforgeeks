//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        int ans=0;
        if(n==1){
            return matrix[0][0];
        }
        else if(n==2){
            return (matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]);
        }
        else{
            int sign=1;
            for(int i=0;i<n;i++){
                int q[][]=new int[n-1][n-1];
                for(int j=1;j<n;j++){
                    int x=0;
                    for(int k=0;k<n;k++){
                       if(k==i){
                           continue;
                       }
                        q[j-1][x++]=matrix[j][k];
                    }
                }
                ans=ans+(sign*matrix[0][i]*determinantOfMatrix(q,n-1));
            
                sign=-1*sign;
            }

        }
        return ans;
    }
}

