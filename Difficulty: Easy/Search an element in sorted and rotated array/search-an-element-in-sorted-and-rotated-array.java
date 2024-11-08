//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		array[i] = sc.nextInt();
        	}
        	int target = sc.nextInt();

            Solution ob = new Solution();
			System.out.println(ob.Search(array,target));
            t--;
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int Search(int arr[], int target)
	{
	    // code here
	    int n=arr.length;
	    int low=0;
	    int high=n-1;
	   while(low<=high){
	       int mid=(low+high)/2;
	       if(arr[mid]==target){
	           return mid;
	       }
	       else if(arr[low]<arr[mid]){
	           if(arr[low]<=target && arr[mid]>=target){
	               high=mid-1;
	           }
	           else{
	               low=mid+1;
	           }
	       }
	       else{
	           if(arr[mid]<=target && arr[high]>=target){
	               low=mid+1;
	           }
	           else{
	               high=mid-1;
	           }
	       }
	   }
	   return -1;
	}
}