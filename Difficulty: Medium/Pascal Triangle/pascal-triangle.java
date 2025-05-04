//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(1);
        for(int i=2;i<=n;i++){
           // System.out.println(a1);
            ArrayList<Integer> a2=new ArrayList<>();
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    a2.add(1);
                }
                else{
                    a2.add(a1.get(j-2)+a1.get(j-1));
                }
            }
            a1=a2;
        }
        return a1;
    }
    
}