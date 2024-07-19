//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    int[] constructLowerArray(int[] arr) {
        // code here
        // int n=arr.length;
        // int ans[]=new int[n];
        // ans[n-1]=0;
        // Stack<Integer> s1=new Stack<>();
        // s1.add(arr[n-1]);
        // for(int i=n-2;i>=0;i--){
        //     Stack<Integer> s2=new Stack<>();
        //     while(!s1.isEmpty() && s1.peek()>=arr[i]){
        //         s2.add(s1.pop());
        //     }
            
        //     ans[i]=s1.size();
            
        //     if(n!=0){
        //         s1.add(arr[i]);
        //       while(!s2.isEmpty()){
        //         s1.add(s2.pop());
        //       }  
        //     }
            
        
        // }
        // return ans;
         int n = arr.length;
        int[] ans = new int[n];
        ArrayList<Integer> temp = new ArrayList<>();
        // Copy elements to ArrayList
        for (int i = 0; i < n; i++) {
            temp.add(arr[i]);
        }

        // Sort the ArrayList
        Collections.sort(temp);

        // Construct the lower array
        for (int i = 0; i < n; i++) {
            int index = binarySearch(temp, arr[i]); // Use binary search to find the index
            ans[i] = index;
            temp.remove(index);  // Remove the element at the found index
        }

        return ans;
        
    }
    public int binarySearch(ArrayList<Integer> temp, int x) {
        int left = 0;
        int right = temp.size() - 1;
        int mid=0;
        while (left <= right) {
            mid = (right +left) / 2;
             if (temp.get(mid) < x) {
                left = mid + 1;
            } else {
               right=mid-1;
            }
            
        }
        if(temp.get(left)==x){
                return left;
        }

        return mid; 
    }

    
    
}