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
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<n;i++){
            h1.put(arr[i],i);
        }
        for(int i=0;i<n;i++){
            int t=arr[i];
            int temp=1;
            while(h1.containsKey(t+1)){
                temp++;
                t=t+1;
            }
            max=(int)Math.max(max,temp);
        }
        return max;
    }
}