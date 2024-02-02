//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        // Code here
        int c1=0;
        ArrayList<Integer> t=new ArrayList<>();
	    ArrayList<Integer> p=new ArrayList<>();
        for(int i=0;i<n;i++){
	        if(arr[i]=='T'){
	            t.add(i);
	        }
	        else if(arr[i]=='P'){
	            p.add(i);
	        }
	    }
	    int i=0;
	     int j=0;
	    while(i<p.size() && j<t.size()){
	        if((int)Math.abs(t.get(j)-p.get(i))<=k){
	            c1++;
	            i++;
	            j++;
	        }
	        else if(t.get(j)>p.get(i)){
	            i++;
	        }
	        else{
	            j++;
	        }
	    }
	    return c1;
	} 
} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends