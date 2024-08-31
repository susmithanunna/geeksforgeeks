//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        Arrays.sort(arr);
        int n=arr.length;
        int index=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                index=i;
                break;
            }
        }
        int i=index+1;
        if( index!=-1 && arr[index]>1){
            return 1;
        }
        else if(index==-1){
            return 1;
        }
        //System.out.println(i);
       while(i<n){
            while(i-1>=0 && i<n && arr[i-1]==arr[i]){
                i++;
            }
            if(i-1>=0 && i<n && arr[i-1]+1!=arr[i]){
                return arr[i-1]+1;
            }
            i++;
        }
        return arr[n-1]+1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends