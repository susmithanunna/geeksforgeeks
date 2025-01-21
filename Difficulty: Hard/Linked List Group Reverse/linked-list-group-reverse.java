//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        Node ans=new Node(-1);
        Node dummy=ans;
        Node temp=new Node(-1);
        Node t1=temp;
        int c=0;
        while(head!=null){
            t1.next=new Node(head.data);
            t1=t1.next;
            c++;
            if(c==k){
                c=0;
                Node rev=reverse(temp.next);
                dummy.next=rev;
                while(dummy.next!=null){
                    dummy=dummy.next;
                }
                temp=null;
                t1=null;
                temp=new Node(-1);
                t1=temp;
            }
            head=head.next;
        }
        if(c>0){
            Node rev=reverse(temp.next);
            dummy.next=rev;
            while(dummy.next!=null){
                dummy=dummy.next;
            }
                
        }
        return ans.next;
    }
    
    public static Node reverse(Node head){
        Node nex=head;
        Node prev=null;
        while(nex!=null){
            Node curr=nex.next;
            nex.next=prev;
            prev=nex;
            nex=curr;
        }
        return prev;
    }
    public static void printlist(Node head){
        System.out.println("ans");
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
         System.out.println();
        
    }
    
}
