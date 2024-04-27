//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node middle=findMid(head);
        Node left=head;
        Node right=middle.next;
        middle.next=null;
        right.prev=null;
        
        left=sortDoubly(left);
        right=sortDoubly(right);
        
        Node ans=merge(left,right);
        return ans;
        
    }
    static Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node merge(Node left,Node right){
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        Node ans=new Node(-1);
        Node temp=ans;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next=left;
                left.prev=temp;
                temp=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right.prev=temp;
                temp=right;
                right=right.next;
            }
        }
        while(left!=null){
            temp.next=left;
            left.prev=temp;
            temp=left;
            left=left.next;
        }
        while(right!=null){
            temp.next=right;
            right.prev=temp;
            temp=right;
            right=right.next;
        }
        ans=ans.next;
        ans.prev=null;
        return ans;
    }
}