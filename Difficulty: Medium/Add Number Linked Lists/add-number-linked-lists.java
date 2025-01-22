//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node ans=new Node(-1);
        Node dummy=ans;
        Node rev1=reverse(num1);
        Node rev2=reverse(num2);
        int sum=0;
        int carry=0;
        while(rev1!=null && rev2!=null){
            sum=carry+rev1.data+rev2.data;
            carry=sum/10;
            dummy.next=new Node(sum%10);
            dummy=dummy.next;
            rev1=rev1.next;
            rev2=rev2.next;
        }
        while(rev1!=null){
            sum=carry+rev1.data;
            carry=sum/10;
            dummy.next=new Node(sum%10);
            dummy=dummy.next;
            rev1=rev1.next;
        }
        while(rev2!=null){
            sum=carry+rev2.data;
            carry=sum/10;
            dummy.next=new Node(sum%10);
            dummy=dummy.next;
            rev2=rev2.next;
        }
        if(carry!=0){
            dummy.next=new Node(carry);
            dummy=dummy.next;
        }
        Node t1=reverse(ans.next);
        if(t1.next!=null && t1.data==0){
            return t1.next;
        }
        return t1;
    }
    public static Node reverse(Node head){
        Node rev=head;
        Node prev=null;
        while(rev!=null){
            Node curr=rev.next;
            rev.next=prev;
            prev=rev;
            rev=curr;
        }
        return prev;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends