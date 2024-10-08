//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
      int ans=Integer.MAX_VALUE;
      int c=0;
      for(int i=0;i<n;i++){
          if(arr[i]<=k){
              c++;
          }
      }
      int bad=0;
      for(int i=0;i<c;i++){
          if(arr[i]>k){
              bad++;
          }
      }
      int i=0;
      int j=c;
      
     ans=(int)Math.min(ans,bad);
      ans=(int)Math.min(ans,bad);
      while(i<n && j<n){
          if(arr[i]>k){
              bad--;
          }
          if(arr[j]>k){
              bad++;
          }
          ans=(int)Math.min(ans,bad);
          i++;
          j++;
      }
      return ans;
    }
    
    
}
