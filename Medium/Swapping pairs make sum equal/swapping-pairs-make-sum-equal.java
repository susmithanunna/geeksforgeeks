//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        HashMap<Long,Integer> h1=new HashMap<>();
        long sum1=0;
        long sum2=0;
        Integer c;
        for(int i=0;i<n;i++){
            sum1=sum1+a[i];
        }
        for(int i=0;i<m;i++){
            c=h1.get(b[i]);
            if(c==null){
                c=0;
            }
            h1.put(b[i],c+1);
            sum2=sum2+b[i];
        }
        long t=sum1+sum2;
        if(t%2!=0){
            return -1;
        }
        long diff=(t)/2-sum1;
        for(int i=0;i<n;i++){
            long t1=a[i]+diff;
            if(h1.containsKey(t1)){
                return 1;
            }
        }
        return -1;
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
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends