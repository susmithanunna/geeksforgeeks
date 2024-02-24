//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();   
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();
            
            //display(head);
            Solution obj = new Solution();
            obj.insertInMid(head, key);
            display(head);
            System.out.println();
        }
    }
    
    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        int c=Length(head);
        //System.out.println("c:"+c);
         int c1=c/2;
        //System.out.println("c:"+c1);
        Node p=new Node(data);
        if(c%2!=0){
            c1=c1+1;
        }
        // else{
        //     c1=c1+1;
        // }
         //System.out.println("c1:"+c1);
        int pos=1;
        Node temp=head;
        while(temp.next!=null){
            if(pos==c1){
                break;
            }
            pos++;
            temp=temp.next;
        }
        p.next=temp.next;
        temp.next=p;
        head=temp;
        return head;
        
    }
    public int Length(Node head){
        int c=0;
        Node temp=head;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }
}