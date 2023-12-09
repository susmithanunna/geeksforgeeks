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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int smithNum(int n) {
        // code here
        int s=0;
        int n1=n;
        while(n1>0){
            int t=n1%10;
            s=s+t;
            n1=n1/10;
        }
        ArrayList<Integer> a=prime(n);
        if(a.size()==1){
            return 0;
        }
        int sum=0;
        for(int i=0;i<a.size();i++){
            if((int) Math.floor(Math.log10(n) + 1)>1){
              int k=sumOfDigits(a.get(i));
              sum=sum+k;
            }
            else{
                sum=sum+a.get(i);
            }
        }
            
        if(sum==s){
            return 1;
        }
        return 0;
    }
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+sumOfDigits(n/10);
    }
    static ArrayList<Integer> prime(int n){
        ArrayList<Integer> a=new ArrayList<Integer>();
        while(n%2==0){
            a.add(2);
            n=n/2;
        }
        for(int i=3;i*i<=n;i=i+2){
            while(n%i==0){
                a.add(i);
                n=n/i;
            }
        }
        if(n>1){
            a.add(n);
        }
        return a;
    }
};