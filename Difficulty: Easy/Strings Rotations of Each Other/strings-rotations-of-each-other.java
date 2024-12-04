//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        int n1=s1.length();
        int n2=s2.length();
        if(n1!=n2){
            return false;
        }
        StringBuilder temp=new StringBuilder();
        temp.append(s1);
        temp.append(s1);
        return temp.lastIndexOf(s2)>=0?true:false;
    }
}