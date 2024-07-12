//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // code here
        int l=0;
        int r=0;
        int sum=0;
        
        ArrayList<Integer> ans=new ArrayList<>();
       
        while(r<n){
            sum=sum+arr[r];
            //System.out.println("sum "+sum);
            
             while(sum>s && l<=r){
                   //System.out.println("inside");
                sum=sum-arr[l];
                l++;
            }
            if(sum==s && l<=r){
               // System.out.println(l+" "+r);
                ans.add(l+1);
                ans.add(r+1);
                return ans;
            }
           r++;
        }
          if(s==0){
            ans.add(-1);
            return ans;
        }
        while(sum>s && l<r){
            sum=sum-arr[l];
            l++;
            if(sum==s){
                ans.add(l+1);
                ans.add(r);
                return ans;
            }
            
        }
        if(s==sum){
            ans.add(l);
            ans.add(r);
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
}
