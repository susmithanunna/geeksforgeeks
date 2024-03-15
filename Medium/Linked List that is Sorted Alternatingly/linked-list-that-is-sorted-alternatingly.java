//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node h1=new Node(-1);
        Node h2=new Node(-1);
        Node ch1=h1;
        Node ch2=h2;
        Node curr=head;
        while(curr!=null){
            ch1.next=curr;
            ch1=ch1.next;
            curr=curr.next;
            if(curr!=null){
                ch2.next=curr;
                ch2=ch2.next;
                curr=curr.next;
            }
            ch1.next=null;
            ch2.next=null;
        }
        h1=h1.next;
        h2=h2.next;
        h2=reverse(h2);
        return merge(h1,h2);
   }
   public Node merge(Node h1,Node h2){
       Node dummy=new Node(0);
       Node curr=dummy;
       while(h1!=null && h2!=null){
           if(h1.data<h2.data){
               curr.next=h1;
               h1=h1.next;
           }
           else{
               curr.next=h2;
               h2=h2.next;
           }
           curr=curr.next;
       }
       if(h1!=null){
           curr.next=h1;
       }
       if(h2!=null){
           curr.next=h2;
       }
       return dummy.next;
   }
   public Node reverse(Node head){
       Node prev=null;
       Node curr=head;
       while(curr!=null){
           Node front=curr.next;
           curr.next=prev;
           prev=curr;
           curr=front;
       }
       return prev;
   }


}