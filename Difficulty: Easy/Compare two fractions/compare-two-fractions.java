//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here

        String c[]=str.split("[/,]");
        
        int t1=Integer.parseInt(c[0]);
        int t2=Integer.parseInt(c[1]);
        int t3=Integer.parseInt(c[2].trim());
        int t4=Integer.parseInt(c[3]);
        if((t1==0 && t3==0) || (t1==t3 && t2==t4)){
            return "equal";
        }
       int div1=t1*t4;
        double div2=t3*t2;
        //System.out.println("div "+div1+" "+div2);
        if(div1>div2){
            return c[0]+"/"+c[1];
        }
        else if(div1==div2){
            return "equal";
        }
        return c[2].trim()+"/"+c[3].trim();
    }
}
