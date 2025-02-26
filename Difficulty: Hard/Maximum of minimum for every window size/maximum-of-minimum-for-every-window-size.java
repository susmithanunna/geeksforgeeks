//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     int n=arr.length;
    //     for(int k=0;k<n;k++){
    //         int t=find(arr,k+1,n);
    //         ans.add(t);
    //     }
    //     return ans;
    // }
    // public int find(int arr[],int k,int n){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(a,b));
    //     int max=0;
    //     for(int i=0;i<k;i++){
    //         pq.add(arr[i]);
    //     }
    //     max=(int)Math.max(max,pq.peek());
    //     for(int i=k;i<n;i++){
    //         pq.remove(arr[i-k]);
    //         pq.add(arr[i]);
    //         max=(int)Math.max(pq.peek(),max);
    //     }
    //     return max;
    int n=arr.length;
    int nextsmall[]=new int[n];
    int prevsmall[]=new int[n];
    Stack<Integer> s1=new Stack<>();
    int i=0;
    while(i<n){
        if(s1.isEmpty() || arr[i]>=arr[s1.peek()]){
            s1.push(i);
            i++;
        }
        else{
            int v=s1.pop();
            prevsmall[v]=s1.isEmpty()?-1:s1.peek();
            nextsmall[v]=i;
        }
    }
    while(!s1.isEmpty()){
        int v=s1.pop();
        prevsmall[v]=s1.isEmpty()?-1:s1.peek();
        nextsmall[v]=n;
    }
    ArrayList<Integer> ans=new ArrayList<>(n);
    for(int j=0;j<n;j++){
        ans.add(0);
    }
    for(int j=0;j<n;j++){
        int len=nextsmall[j]-prevsmall[j]-1;
        ans.set(len-1,Math.max(ans.get(len-1),arr[j]));
    }
    for(int j=n-2;j>=0;j--){
        ans.set(j,Math.max(ans.get(j),ans.get(j+1)));
    }
    return ans;
    }
}