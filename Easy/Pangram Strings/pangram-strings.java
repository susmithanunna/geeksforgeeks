//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPanagram(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPanagram(String S) {
        // code here
        S=S.toLowerCase();
        HashMap<Character,Integer> h1=new HashMap<>();
	    Integer c;
	    for(int i=0;i<S.length();i++){
	        c=h1.get(S.charAt(i));
	        if(c==null){
	            c=0;
	        }
	        if(S.charAt(i)>='a' && S.charAt(i)<='z'){
	        h1.put(S.charAt(i),c+1);
	        }
	    }
	    if(h1.size()==26){
	        return 1;
	    }
	    return 0;
    }
};