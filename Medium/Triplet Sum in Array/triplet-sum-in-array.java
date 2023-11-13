//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code Here
       int c=0;
       Arrays.sort(A);
       for(int i=0;i<n;i++){
           int j=i+1;
           int k=n-1;
           if(i>0 && A[i]==A[i-1])
           {
               continue;
           }
           while(j<k){
               int sum=A[i]+A[j]+A[k];
               if(sum<X){
                   j++;
               }
               else if(sum>X){
                   k--;
               }
               else{
                   c++;
                   j++;
                   k--;
                   while( j<k && A[j]!=A[j-1]){
                     j++;
                  }
                  while(j<k && A[k]!=A[k+1]){
                      k--;
                  }
               }
               
           }
       }
       if(c>0){
           return true;
       }
       return false;
    
    }
}
