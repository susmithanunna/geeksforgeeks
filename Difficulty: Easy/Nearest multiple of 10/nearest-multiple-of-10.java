//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        // Long t=Long.valueOf(str);
        int n=str.length();
        StringBuilder t=new StringBuilder(str);
        if(str.charAt(n-1)<='5'){
           t.setCharAt(n-1,'0');
           return t.toString();
        }
        t.setCharAt(n-1,'0');
        int i=n-2;
        while(i>=0 && str.charAt(i)=='9'){
            t.setCharAt(i,'0');
            i--;
        }
        if(i<0){
            return t.insert(0,'1').toString();
            
        }
        else{
            t.setCharAt(i,(char)(t.charAt(i)+1));
        }
        return t.toString();
        
        
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

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends