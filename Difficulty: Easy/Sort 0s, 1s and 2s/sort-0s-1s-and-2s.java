//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int oc=0;
        int tc=0;
        int zc=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==1){
                oc++;
            }
            else if(arr.get(i)==2){
                tc++;
            }
            else{
                zc++;
            }
        }
        int k=0;
        for(int i=0;i<zc;i++){
            arr.set(k,0);
            k++;
        }
        for(int i=0;i<oc;i++){
            arr.set(k,1);
            k++;
        }
        for(int i=0;i<tc;i++){
            arr.set(k,2);
            k++;
        }
    }
}