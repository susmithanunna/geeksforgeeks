//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int n=S.length();
        int i=0;
        int j=0;
        int min=Integer.MAX_VALUE;
        int zero=0;
        int one=0;
        int two=0;
        while(i<n && j<n){
            
            if(S.charAt(j)=='0'){
                zero++;
            }
            else if(S.charAt(j)=='1'){
                one++;
            }
            else{
                two++;
            }
            while(zero>0 && one>0 && two>0 && j-i+1>=3){
                min=(int)Math.min(min,j-i+1);
                if(S.charAt(i)=='0'){
                    zero--;
                }
                else if(S.charAt(i)=='1'){
                    one--;
                }
                else{
                    two--;
                }
                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE){
            return -1;
            
        }
        return min;
       
    }
};
