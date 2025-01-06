//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        int c1=-1;
        int c2=-1;
        int min=Integer.MAX_VALUE;
        while(i<j){
            int t=arr[i]+arr[j];
            if((int)Math.abs(target-t)<min){
                c1=arr[i];
                c2=arr[j];
                min=(int)Math.abs(target-t);
            }
            if(t>target){
                j--;
            }
            else{
                i++;
            }
        }
        if(c1==-1){
            return ans;
        }
        ans.add(c1);
        ans.add(c2);
        return ans;
    }
}