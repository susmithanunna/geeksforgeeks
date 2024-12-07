//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static ArrayList<Integer> a1=new ArrayList<>();

    static int inversionCount(int arr[]) {
        // Your Code Here
        int n=arr.length;
        int ans=mergesort(arr,0,n-1);
        return ans;
    }
    static int mergesort(int arr[],int low,int high){
        if(low>=high){
            return 0;
        }
            int mid=(low+high)/2;
            int temp=mergesort(arr,low,mid);
            temp=temp+mergesort(arr,mid+1,high);
            temp=temp+merge(arr,low,mid,high);
            return temp;
        
    }
    static int merge(int arr[],int low,int mid,int high){
       int i=low;
       int j=mid+1;
       int c=0;
       while(i<=mid && j<=high){
           if(arr[i]<=arr[j]){
               a1.add(arr[i]);
               i++;
           }
           else{
               a1.add(arr[j]);
               j++;
               c=c+mid-i+1;
           }
       }
       while(i<=mid){
          a1.add(arr[i]);
          i++;
       }
       while(j<=high){
           a1.add(arr[j]);
           j++;
       }
       for(int k=low;k<=high;k++){
           arr[k]=a1.get(k-low);
       }
       a1=new ArrayList<>();
       return c;
     
    }
    //   static long mergeSort(long arr[],long low,long high){
    //     if(low>=high){
    //         return 0;
    //     }
    //     long mid=(low+high)/2;
    //     long c=0;
    //     c=c+mergeSort(arr,low,mid);
    //     c=c+mergeSort(arr,mid+1,high);
    //     c=c+merge(arr,low,mid,high);
    //     return c;
    // }
    // static long merge(long arr[],long low,long mid,long high){
    //     int i=(int)low;
    //     int j=(int)mid+1;
    //     long c=0;
    //     while(i<=mid && j<=high){
    //         if(arr[i]<=arr[j]){
    //             temp.add(arr[i++]);
    //         }
    //         else{
    //             temp.add(arr[j++]);
    //             c=c+mid-i+1;
    //         }
    //     }
    //     while(i<=mid){
    //         temp.add(arr[i++]);
    //     }
    //     while(j<=high){
    //         temp.add(arr[j++]);
    //     }
    //     for(int k=(int)low;k<=(int)high;k++){
    //         arr[k]=temp.get(k-(int)low);
    //     }
    //     temp=new ArrayList<>();
    //     return c;
    // }
}