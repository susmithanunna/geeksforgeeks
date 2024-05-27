//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev= null;
    }

} 
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
            }
            
            Solution obj = new Solution();
            Node ans = obj.constructDLL(arr);
            while(ans!=null){
                System.out.print(ans.data+" ");
                ans=ans.next;
            }
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    Node constructDLL(int arr[]) {
        // Code here
        Node root=new Node(arr[0]);
        root.prev=null;
        Node t1=root;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            temp.prev=t1;
            temp.next=null;
            t1.next=temp;
            t1=temp;
        }
        return root;
        
    }
}