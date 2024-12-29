//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int ans[]=new int[2];
        int n=arr.length;
        int floor=-1;
        int ceil=-1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=x){
                floor=mid;
                low=mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
        }
        low=0;
        high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ceil=mid;
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
        }
      //  System.out.println(floor+" "+ceil);
       if(floor!=-1){
            ans[0]=arr[floor];
       }
       else{
           ans[0]=-1;
       }
        if(ceil!=-1){
            ans[1]=arr[ceil];
        }
        else{
            ans[1]=-1;
        }
        return ans;
    }
}
