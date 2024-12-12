//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        HashMap<Integer,Integer> h1=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            Integer c=h1.get(arr[i]);
            if(c==null){
                c=0;
            }
            h1.put(arr[i],c+1);
        }
        for(int it:h1.keySet()){
            if(it==target){
                return h1.get(it);
            }
        }
        return 0;
    }
}
