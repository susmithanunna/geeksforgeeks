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
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n=nums.size();
        int t=n/3;
         ArrayList<Integer> ans=new ArrayList<>();
       int e1=-1;
       int e2=-1;
       int c1=0;
       int c2=0;
       for(int i=0;i<n;i++){
           int curr=nums.get(i);
           if(curr==e1){
               c1++;
           }
           else if(curr==e2){
               c2++;
           }
           else if(c1==0){
               e1=curr;
               c1=1;
           }
           else if(c2==0){
               e2=curr;
               c2=1;
           }
           else{
               c1--;
               c2--;
           }
       }
       
       c1=0;
       c2=0;
       for(int i=0;i<n;i++){
           int curr=nums.get(i);
           if(curr==e1){
               c1++;
           }
           else if(curr==e2){
               c2++;
           }
       }
       if(c1>t){
           ans.add(e1);
       }
       if(c2>t && e1!=e2){
           ans.add(e2);
       }
       if(ans.isEmpty()){
           ans.add(-1);
       }
       return ans;
    }
}
