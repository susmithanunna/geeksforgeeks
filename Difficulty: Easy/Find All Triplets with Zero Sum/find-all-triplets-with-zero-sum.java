//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,List<Integer>> h1=new HashMap<>();
        for(int i=0;i<n;i++){
            if(h1.containsKey(arr[i])){
                h1.get(arr[i]).add(i);
                
                
            }
            else{
                List<Integer> a1=new ArrayList<>();
                a1.add(i);
                h1.put(arr[i],a1);
            }
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int sum=-1*(arr[i]+arr[j]);
                if(h1.containsKey(sum)){
                    List<Integer> l1=h1.get(sum);
                    for(int k:l1){
                        if(k>j){
                            List<Integer> a1=new ArrayList<>();
                            a1.add(i);
                            a1.add(j);
                            a1.add(k);
                            ans.add(a1);
                        }
                    }
                }
            }
        }
        return ans;
        
    }
}

//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends