//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int n=S.length();
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;
        ArrayList<Character> a1=new ArrayList<>();
        while(j<n){
            if(a1.contains(S.charAt(j))){
                //System.out.println(a1);
                max=(int)Math.max(max,a1.size());
                a1=new ArrayList<>();
                i++;
                j=i;
            }
            else{
                a1.add(S.charAt(j));
                j++;
            }
        }
        max=(int)Math.max(max,a1.size());
        return max;
    }
}