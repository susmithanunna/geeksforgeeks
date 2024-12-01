//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        HashMap<Character,Integer> h1=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            Integer c=h1.get(s.charAt(i));
            if(c==null){
                c=0;
            }
            h1.put(s.charAt(i),c+1);
        }
        for(int i=0;i<n;i++){
            if(h1.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return '$';
    }
}
