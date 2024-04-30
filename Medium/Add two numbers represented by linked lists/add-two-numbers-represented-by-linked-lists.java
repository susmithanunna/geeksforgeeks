//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

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

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node temp1=reverse(num1);
        Node temp2=reverse(num2);
        Node ans=new Node(0);
        int carry=0;
        Node a1=ans;
        int sum=0;
        while(temp1!=null && temp2!=null){
            sum=carry+temp1.data+temp2.data;
            carry=sum/10;
            ans.next=new Node(sum%10);
            ans=ans.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            sum=carry+temp1.data;
            carry=sum/10;
            ans.next=new Node(sum%10);
            ans=ans.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            sum=carry+temp2.data;
            carry=sum/10;
            ans.next=new Node(sum%10);
            ans=ans.next;
            temp2=temp2.next;
        }
        if(carry!=0){
            ans.next=new Node(carry);
            ans=ans.next;
        }
        a1=reverse(a1.next);
        while(a1.next!=null && a1.data==0){
            a1=a1.next;
        }
        return a1;
        
    }
    static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node nex;
        while(curr!=null){
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
            
        }
        head=prev;
        return head;
    }
}


