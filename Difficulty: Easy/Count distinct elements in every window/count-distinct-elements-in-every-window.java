//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> h1=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            Integer c=h1.get(arr[i]);
            if(c==null){
                c=0;
            }
            h1.put(arr[i],c+1);
        }
        ans.add(h1.size());
        int t=0;
        int j=k;
        int i=0;
        while(j<n){
            Integer c=h1.get(arr[i]);
            if(c==1){
                h1.remove(arr[i]);
            } 
            else{
                h1.put(arr[i],c-1);
                
            }
            i++;
            c=h1.get(arr[j]);
            if(c==null){
                c=0;
            }
            h1.put(arr[j],c+1);
            ans.add(h1.size());
            j++;
            
        }
        return ans;
    }
}
