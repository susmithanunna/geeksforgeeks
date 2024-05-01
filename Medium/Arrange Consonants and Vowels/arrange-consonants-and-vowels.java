//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        ArrayList<Character> a1=new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        int cons=0;
        int len=0;
        Node tail=null;
        while(temp!=null){
            if(!a1.contains(temp.data)){
                cons++;
            }
            if(temp.next==null){
                tail=temp;
            }
            len++;
            temp=temp.next;
        }
        if(cons==len || cons==0){
            return head;
        }
        //Node temp=head;
        while(head!=null && !a1.contains(head.data)){
            Node x=head;
            head=head.next;
            tail.next=x;
            tail=x;
            tail.next=null;
            cons--;
        }
        temp=head;
        Node prev=null;
        while(cons>0){
            if(tail==temp){
                break;
            }
            if(!a1.contains(temp.data)){
                prev.next=temp.next;
                tail.next=temp;
                tail=temp;
                tail.next=null;
                cons--;
                temp=prev.next;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
    }
}



