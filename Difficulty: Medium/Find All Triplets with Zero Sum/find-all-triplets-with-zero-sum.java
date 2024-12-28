//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        HashMap<Integer,Integer> h1=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t=-1*(arr[i]+arr[j]);
                if(h1.containsKey(t) && h1.get(t)!=i && h1.get(t)!=j  && i!=j){
                    List<Integer> l1=new ArrayList<>();
                    l1.add(i);
                    l1.add(j);
                    l1.add(h1.get(t));
                    Collections.sort(l1);
                    hs.add(l1);
                    // if(!ans.contians(l1)){
                    //     ans.add(l1);
                    // }
                }
                else{
                    h1.put(arr[j],j);
                }
                
            }
        }
        for(List<Integer> l1:hs){
            ans.add(l1);
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