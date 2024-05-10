//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        find(arr,ans,temp,0,k);
        return ans;
    }
    public void find(int arr[],List<List<Integer>> ans,List<Integer> temp,int index,int k){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k<0 || index>arr.length){
            return ;
        }
        for(int i=index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]){
                continue;
            }
            else{
                temp.add(arr[i]);
                find(arr,ans,temp,i+1,k-arr[i]);
                temp.remove(temp.size()-1);
            }
            
        }
        return ;
    }
}
