//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> ans=new ArrayList<>();
      HashMap<Integer,Integer> h1=new HashMap<>();
      int n=nums.length;
      for(int i=0;i<n;i++){
          Integer c=h1.get(nums[i]);
          if(c==null){
              c=0;
          }
          h1.put(nums[i],c+1);
      }
      for(int it:h1.keySet()){
          if(h1.get(it)>n/3){
              ans.add(it);
          }
      }
      return ans;
    }
}
