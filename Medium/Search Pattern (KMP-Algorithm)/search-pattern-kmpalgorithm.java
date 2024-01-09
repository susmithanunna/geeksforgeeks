//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
                ArrayList<Integer> indices = new ArrayList<>();

        if (pat.length() == 0 || txt.length() == 0 || pat.length() > txt.length()) {
            return indices; // Empty list if pattern or text is empty, or pattern is longer than text
        }

        int[] lps = computeLPSArray(pat);
        int patLength = pat.length();
        int txtLength = txt.length();
        int i = 0, j = 0;

        while (i < txtLength) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == patLength) {
                indices.add(i - j + 1); // Adjust index by adding 1 before adding to indices
                j = lps[j - 1];
            } else if (i < txtLength && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return indices;
    }

    private int[] computeLPSArray(String pat) {
        int patLength = pat.length();
        int[] lps = new int[patLength];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < patLength) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}