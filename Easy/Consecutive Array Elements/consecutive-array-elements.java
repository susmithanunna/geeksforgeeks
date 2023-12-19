//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean areConsecutives(long arr[], int N)
    {
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        long sum=0;
        long ans=0;
        long n=0;
       for(int i=0;i<N;i++){
           if(max<arr[i]){
               max=arr[i];
           }
           if(min>arr[i]){
               min=arr[i];
           }
           sum=sum+arr[i];
       }
       n=(max-min+1);
       ans=(n*(max+min))/2;
       
        if(sum==ans){
            return true;
        }
        return false;
        

    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            boolean ans=ob.areConsecutives(a,n);
           // System.out.println(ob.shuffleArray(a,n));
            if(ans)
            System.out.println("Yes");
            else
            System.out.println("No");

        }
    }
}



// } Driver Code Ends