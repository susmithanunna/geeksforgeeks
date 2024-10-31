//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        
System.out.println("~");
}

        sc.close();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node temp=head;
        boolean flag=false;
        Node prev1=null;
        if(temp!=null && temp.data>=x){
              Node t1=new Node(x);
                t1.next=temp;
                //temp.prev=t1;
                return t1;
        }
        while(temp!=null){
            if(prev1!=null && prev1.data<=x && temp.data>=x){
                Node t1=new Node(x);
                t1.next=temp;
                t1.prev=prev1;
                prev1.next=t1;
                flag=true;
                break;
            }
            else{
                prev1=temp;
                temp=temp.next;
            }
        }
        if(prev1.data<=x && flag==false){
             Node t1=new Node(x);
                t1.next=temp;
                t1.prev=prev1;
                prev1.next=t1;
        }
        
        return head;
        
    }
}