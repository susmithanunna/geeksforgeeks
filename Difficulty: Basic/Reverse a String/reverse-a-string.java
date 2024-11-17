//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str = read.readLine();
            System.out.println(new Solution().reverseString(str));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        int n=s.length();
        int i=0;
        int j=n-1;
        char arr[]=new char[n];
        while(i<=j){
            char ch=s.charAt(i);
            arr[i]=s.charAt(j);
            arr[j]=ch;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
}