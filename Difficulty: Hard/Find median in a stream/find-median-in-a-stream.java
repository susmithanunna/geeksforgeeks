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
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
       PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Integer> minheap=new PriorityQueue<>();
       ArrayList<Double> a1=new ArrayList<>();
       for(int val:arr){
           if(maxheap.isEmpty() || maxheap.peek()>=val){
               maxheap.add(val);
           }
           else{
               minheap.add(val);
           }
           if(maxheap.size()>minheap.size()+1){
               minheap.add(maxheap.poll());
           }
           else if(maxheap.size()<minheap.size()){
               maxheap.add(minheap.poll());
           }
           if(maxheap.size()==minheap.size()){
               a1.add(maxheap.peek()/2.0+minheap.peek()/2.0);
           }
           else{
               a1.add((double)maxheap.peek());
           }
       }
       return a1;
    }
}