//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();
            obj.segregateElements(a, n);

            for (int i = 0; i < n; i++) ot.print(a[i] + " ");

            ot.println();
        }
        ot.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public void segregateElements(int arr[], int n) {
        // Your code goes here
        // int i=0;
        // int j=1;
        // int pc=0;
        // while(i<n && j<n){
        //     if(arr[i]<0 && arr[j]>=0){
        //         if(i+1!=j){
        //             int t1=arr[j];
        //             for(int k=j;k>=i;k--){
        //                 if(k<0 || k>n){
        //                     break;
        //                 }
        //                 if(k-1>=0 && k-1<n){
        //                      arr[k]=arr[k-1];
        //                 }
                       
        //             }
        //             arr[i]=t1;
        //             i++;
        //         }
        //         else{
        //         int t=arr[i];
        //         arr[i]=arr[j];
        //         arr[j]=t;
        //         i++;
        //         j++;
        //         }
        //     }
        //     else if(arr[i]<0 && arr[j]<0){
        //         j++;
        //     }
        //     else{
        //         i++;
        //         j++;
        //     }
        // }
        
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                a2.add(arr[i]);
            }
            else{
                a1.add(arr[i]);
            }
        }
        for(int i=0;i<a1.size();i++){
            arr[i]=a1.get(i);
        }
        int j=a1.size();
        for(int i=0;i<a2.size();i++){
            arr[i+j]=a2.get(i);
            //j++;
        }
        
       
        
    }
}