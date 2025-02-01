//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int i=0;
        int j=0;
        int n=arr.length;
        int max=0;
        HashMap<Integer,Integer> h1=new HashMap<>();
        while(i<=j && j<n){
            Integer c=h1.get(arr[j]);
            if(c==null){
                c=0;
            }
            h1.put(arr[j],c+1);
            if(i<=j && h1.size()>2 ){
               c=h1.get(arr[i]);
               
                if(c==1){
                    h1.remove(arr[i]);
                }
                else{
                    h1.put(arr[i],c-1);
                }
                i++;
            }
             max=(int)Math.max(max,j-i);
            j++;
            
        }
        max=(int)Math.max(max,j-i);
        return max;
    }
}