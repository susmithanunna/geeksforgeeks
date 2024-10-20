//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public int[] countFreq(int arr[]) {

        // complete the function
        int n=arr.length;
        TreeMap<Integer,Integer> h1=new TreeMap<>();
        for(int i=0;i<n;i++){
            Integer c=h1.get(arr[i]);
            if(c==null){
                c=0;
            }
            h1.put(arr[i],c+1);
        }
        int ans[]=new int[h1.size()];
        int i=0;
        int mod=(int)Math.pow(10,9)+7;
        int cum_sum=0;
        for(int it:h1.keySet()){
            cum_sum=(cum_sum+h1.get(it))%mod;
            ans[i]=(cum_sum)%mod;
            i++;
        }
       // Arrays.sort(ans);
        return ans;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
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
            Solution obj = new Solution();
            int answer[] = obj.countFreq(arr);
            int sz = answer.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++) output.append(answer[i] + " ");
            System.out.println(output);
        }
    }
}
// } Driver Code Ends