//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n1=arr1.length;
        int n2=arr2.length;
        int mid=((n1+n2)/2)-1;
        int i=0;
        int j=0;
        int c=0;
        int flag=0;
        int sum=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                if(c==mid || (c==mid+1 && flag==1) ){
                    sum=sum+arr1[i];
                    if(flag==1){
                       flag=2;
                   }
                   else{
                       flag=1;
                   }
                }
                i++;
                c++;
            }
            else{
                if(c==mid || (c==mid+1 && flag==1)){
                    sum=sum+arr2[j];
                   if(flag==1){
                       flag=2;
                   }
                   else{
                       flag=1;
                   }
                }
                j++;
                c++;
            }
        }
        while(i<n1 && flag!=2){
            if(c==mid || (c==mid+1 && flag==1)){
                sum=sum+arr1[i];
                if(flag==1){
                       flag=2;
                   }
                   else{
                       flag=1;
                   }
            }
            i++;
            c++;
        }
        while(j<n2 && flag!=2){
            if(c==mid || (c==mid+1 && flag==1)){
                sum=sum+arr2[j];
               if(flag==1){
                       flag=2;
                   }
                   else{
                       flag=1;
                   }
            }
            j++;
            c++;
        }
        return sum;
        
        
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends