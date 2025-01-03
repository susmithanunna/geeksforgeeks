//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
       HashSet<Integer> h1=new HashSet<>();
	   int max=Integer.MIN_VALUE;
	   int c=1;
	   int n=arr.length;
	   for(int i=0;i<n;i++){
	       h1.add(arr[i]);
	   }
	   for(int i=0;i<n;i++){
	       if(!h1.contains(arr[i]-1)){
	           int j=arr[i];
	           while(h1.contains(j)){
	               j++;
	           }
	           max=(int)Math.max(max,j-arr[i]);
	       }
	   }
	   return max;
    }
}