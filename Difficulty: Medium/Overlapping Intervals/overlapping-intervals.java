//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> ans=new ArrayList<>();
       int temp1=arr[0][0];
       int temp2=arr[0][1];
       int n=arr.length;
        for(int i=1;i<n;i++){
           if(temp2>=arr[i][0]){
               if(temp2<arr[i][1]){
                   temp2=arr[i][1];
               }
           }
           else if(temp2<arr[i][0]){
               ans.add(new int[]{temp1,temp2});
               temp1=arr[i][0];
               temp2=arr[i][1];
           }
        }
        ans.add(new int[]{temp1,temp2});
        return ans;
    }
}