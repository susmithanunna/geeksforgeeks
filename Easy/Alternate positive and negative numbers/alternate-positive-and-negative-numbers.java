//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
       
       ArrayList<Integer> a1=new ArrayList<>();
       ArrayList<Integer> a2=new ArrayList<>();
       for(int i=0;i<n;i++){
           if(arr[i]>=0){
               a1.add(arr[i]);
           }
           else{
               a2.add(arr[i]);
           }
       }
       int k=0;
       int l=0;
       int i=0;
       while(i<n){
           if(i%2==0){
               if(k>=a1.size()){
                   break;
               }
               arr[i]=a1.get(k);
               k++;
           }
           else{
               if(l>=a2.size())
               {
                   break;
               }
               arr[i]=a2.get(l);
               l++;
           }
           i++;
       }
       while(k<a1.size()){
           arr[i]=a1.get(k);
               k++;
               i++;
           
       }
       while(l<a2.size()){
           arr[i]=a2.get(l);
           l++;
           i++;
       }
        
    }
    
}