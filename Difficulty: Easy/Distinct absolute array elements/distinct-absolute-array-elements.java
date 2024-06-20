//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int c=n;
	    int l=0;
	    int r=n-1;
	    while(l<r){
	        if(l<r && arr[l]==arr[l+1]){
	        while(l<r && arr[l]==arr[l+1]){
	            l++;
	            c--;
	           //System.out.println("r "+c);
	        }
	        }
	        else if(r>l && arr[r]==arr[r-1]){
	        while(r>l && arr[r]==arr[r-1]){
	            r--;
	            c--;
	            	//System.out.println(" l "+c);
	        }}
	        else if(arr[l]+arr[r]==0){
	            l++;
	            r--;
	            c--;
	            //	System.out.println("-- "+c);
	        }
	       // else if(arr[l]==arr[r]){
	       //     r++;
	       //     l--;
	       //     //c--;
	       // }
	        else if(l==r){
	            break;
	        }
	        else {
	          
	             if(arr[l]+arr[r]>0){
	                r--;
	            }
	            else{
	            l++;}
	           // c--;
	        }
	    }
	    return c;
    }
}
