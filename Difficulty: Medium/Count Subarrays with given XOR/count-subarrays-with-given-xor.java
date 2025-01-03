//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> h1=new HashMap<>();
        int xor=0;
        int c=0;
        for(int i=0;i<n;i++){
            xor=xor^arr[i];
            int t=k^xor;
            if(h1.containsKey(t)){
                c=c+h1.get(t);
            }
             if(xor==k){
                c++;
            }
            if(h1.containsKey(xor)){
                h1.put(xor,h1.get(xor)+1);
            }
            else{
                h1.put(xor,1);
            }
        }
        return c;
    }
}