//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        HashMap<Integer,Integer> h1=new HashMap<>();
        Integer c;
        int n1=n/k;
        int c1=0;
        for(int i=0;i<n;i++){
            c=h1.get(arr[i]);
            if(c==null){
                c=0;
            }
            h1.put(arr[i],c+1);
        }
        for(int i:h1.keySet()){
            if(h1.get(i)>n1){
                c1++;
            }
        }
        return c1;
    }
}
