//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);                                   //[a,c,d,b]
        int max=arr[n-1];                                   //the min diff is lied bt consetive numbers
        int min=arr[0];                                     //max=max(c+k,b-k);
        int ans=max-min;                                    //min=min(a+k,d-k);
        for(int i=1;i<n;i++){
            max=(int)Math.max(arr[i-1]+k,arr[n-1]-k);
            min=(int)Math.min(arr[i]-k,arr[0]+k);
            ans=(int)Math.min(ans,max-min);
        }
        return ans;
    }
}