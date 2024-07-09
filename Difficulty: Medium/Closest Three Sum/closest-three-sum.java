//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] arr, int target) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        if(n<2){
            return -1;
        }
        int ans=arr[0]+arr[1]+arr[2];
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if((int)Math.abs(target-ans)>(int)Math.abs(target-sum)){
                    ans=sum;
                }
                else if((int)Math.abs(target-sum)==(int)Math.abs(target-ans)){
                    ans=(int)Math.max(sum,ans);
                }
                if(sum>target){
                    k--;
                }
                else if(sum<target){
                    j++;
                }
                else if(sum==target){
                    return sum;
                }
            }
        }
        return ans;
    }
}
//-7 1 1 3 8 9