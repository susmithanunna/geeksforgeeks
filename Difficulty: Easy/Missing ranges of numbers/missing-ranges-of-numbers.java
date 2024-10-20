//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public String findMissing(int[] arr) {
        //  code here
        Arrays.sort(arr);
        int n=arr.length;
        String ans="";
        if(arr[0]>1){
            ans=ans+"0-"+String.valueOf((arr[0]-1))+" ";
        }
        else if(arr[0]==1){
            ans=ans+"0 ";
        }
        for(int i=1;i<n;i++){
            if((int)Math.abs(arr[i-1]-arr[i])>=2 && arr[i-1]+1!=arr[i]-1){
                ans=ans+String.valueOf(arr[i-1]+1)+"-"+String.valueOf(arr[i]-1)+" ";
            }
            if(arr[i-1]+1==arr[i]-1){
                ans=ans+String.valueOf(arr[i-1]+1)+" ";
            }
        }
        if(ans.length()==0){
            ans=ans+"-1";
        }
        return ans.trim();
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
            String res = obj.findMissing(arr);

            System.out.println(res);

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends