//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int q = sc.nextInt();
      int ind[]=new int[q]; 
      for(int i=0;i<q;i++) ind[i]=sc.nextInt();
      Solution obj = new Solution();
      int ans[] = obj.count_NGEs(n,a,q,ind);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    int ng[]=new int[N];
    for(int i=N-1;i>=0;i--){
        
        while(!s1.isEmpty() && s1.peek()<=arr[i]){
            s2.push(s1.pop());
        }
        if(!s1.isEmpty()){
            ng[i]=s1.size();
            //System.out.println(ng[i]);
        }
        else{
            ng[i]=0;
        }
        s1.push(arr[i]);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
    }
    int ans[]=new int[queries];
    for(int i=0;i<queries;i++){
        ans[i]=ng[indices[i]];
    }
    return ans;
     
  }
}
     