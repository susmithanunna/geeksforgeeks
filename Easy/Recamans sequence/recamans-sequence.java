//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(0);
        int prev=0;
        for(int i=1;i<n;i++){
            int a=prev-i;
           //System.out.println("111i:"+i+" not contains"+a);            if(a>0){
                if(a1.contains(a)){
                   // System.out.println("contains i:"+i+" a:"+a);
                    a=prev+i;
                    prev=a;
                    //System.out.println("prev:"+prev);
                    a1.add(a);
                }
                else{
                   //System.out.println("i:"+i+" not contains"+a);
                   prev=a;
                    a1.add(a);
                }
            }
            else{
                a=prev+i;
                prev=a;
                //System.out.println("prev:"+prev);
                a1.add(a);
            }
        }
        return a1;
    }
    // static int find(int n){
    //     if(n==0){
    //         return 0;
    //     }
    //     return find(n-1);
    // }
}