//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(1);
        for(int i=2;i<=n;i++){
            int carry=0;
            for(int j=0;j<ans.size();j++){
                int t=ans.get(j)*i+carry;
                ans.set(j,t%10);
                carry=t/10;
            }
            while(carry>0){
                ans.add(carry%10);
                carry=carry/10;
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}

//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val);
            System.out.println();
        }
    }
}
// } Driver Code Ends