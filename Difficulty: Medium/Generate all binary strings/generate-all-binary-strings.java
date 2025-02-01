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
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
      List<String> ans=new ArrayList<>();
      find(n,0,"",ans,0);
      return ans;
  }
  public static void find(int n,int index,String s,List<String> ans,int lastdigit){
      if(index==n){
          ans.add(s);
          return;
      }
      if(lastdigit==0){
          find(n,index+1,s+"0",ans,0);
          find(n,index+1,s+"1",ans,1);
      }
      else{
          find(n,index+1,s+"0",ans,0);
      }
  }
}
     
     