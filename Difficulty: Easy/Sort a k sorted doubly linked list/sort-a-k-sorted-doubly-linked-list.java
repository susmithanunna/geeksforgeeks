//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if(head==null||head.next==null) return head;
        PriorityQueue<DLLNode> p1=new PriorityQueue<>((a,b)->Integer.compare(a.data,b.data));
        DLLNode ans=null;
        DLLNode last=null;
        DLLNode curr=head;
        for(int i=0;i<=k && curr!=null;i++){
            p1.add(curr);
            curr=curr.next;
        }
        while(!p1.isEmpty()){
            DLLNode temp=p1.poll();
            if(ans==null){
                ans=temp;
                ans.prev=null;
                last=ans;
            }
            else{
                last.next=temp;
                temp.prev=last;
                last=temp;
            }
            if(curr!=null){
                p1.add(curr);
                curr=curr.next;
            }
        }
        if(last!=null){
            last.next=null;
        }
        return ans;
    }
}