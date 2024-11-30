//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        int n1=s1.length();
        int n2=s2.length();
        char a1[]=s1.toCharArray();
        char a2[]=s2.toCharArray();
        if(n1!=n2){
            return false;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        for(int i=0;i<n1;i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
}