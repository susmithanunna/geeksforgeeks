//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
     static ArrayList<Long> temp=new ArrayList<>();
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long c=mergeSort(arr,0,N-1);
        return c;
        
    }
    static long mergeSort(long arr[],long low,long high){
        if(low>=high){
            return 0;
        }
        long mid=(low+high)/2;
        long c=0;
        c=c+mergeSort(arr,low,mid);
        c=c+mergeSort(arr,mid+1,high);
        c=c+merge(arr,low,mid,high);
        return c;
    }
    static long merge(long arr[],long low,long mid,long high){
        int i=(int)low;
        int j=(int)mid+1;
        long c=0;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp.add(arr[i++]);
            }
            else{
                temp.add(arr[j++]);
                c=c+mid-i+1;
            }
        }
        while(i<=mid){
            temp.add(arr[i++]);
        }
        while(j<=high){
            temp.add(arr[j++]);
        }
        for(int k=(int)low;k<=(int)high;k++){
            arr[k]=temp.get(k-(int)low);
        }
        temp=new ArrayList<>();
        return c;
    }
}