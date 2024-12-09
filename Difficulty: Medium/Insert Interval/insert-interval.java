//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> temp=new ArrayList<>();
        int t1=newInterval[0];
        int t2=newInterval[1];
        boolean merged=false;
        for(int it[]:intervals){
            if(it[1]<newInterval[0]){
                temp.add(it);
            }
            else if(it[0]>newInterval[1]){
                if(!merged){
                    temp.add(new int[]{t1,t2});
                    merged=true;
                }
                temp.add(it);
            }
            else{
                t1=(int)Math.min(it[0],t1);
                t2=(int)Math.max(it[1],t2);
            }
        }
        if(!merged){
            temp.add(new int[]{t1,t2});
        }
        return temp;
    }
}
