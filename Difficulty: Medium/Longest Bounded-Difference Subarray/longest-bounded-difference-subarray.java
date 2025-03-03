//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n=arr.length;
        ArrayList<Integer> a1=new ArrayList<>();
       Deque<Integer> maxdq=new LinkedList<>();
       Deque<Integer> mindq=new LinkedList<>();
       int max=0;
       int l=0;
       int r=0;
       int s=0;
       while(r<n){
           while(!maxdq.isEmpty() && arr[maxdq.peekLast()]<=arr[r]){
               maxdq.pollLast();
           }
           while(!mindq.isEmpty() && arr[mindq.peekLast()]>=arr[r]){
               mindq.pollLast();
           }
           maxdq.addLast(r);
           mindq.addLast(r);
           while(arr[maxdq.peekFirst()]-arr[mindq.peekFirst()]>x){
               if(maxdq.peekFirst()==l){
                   maxdq.pollFirst();
               }
               if(mindq.peekFirst()==l){
                   mindq.pollFirst();
               }
               l++;
           }
           if(r-l+1>max){
               max=r-l+1;
               s=l;
           }
           r++;
       }
    
       for(int i=s;i<s+max;i++){
           a1.add(arr[i]);
       }
       return a1;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends