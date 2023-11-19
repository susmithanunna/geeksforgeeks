//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
      Node anshead=null;
      Node anstail=null;
      Node a1=head1;
      Node a2=head2;
      while(a1!=null && a2!=null){
          if(a1.data==a2.data){
              if(anshead==null){
                  anshead=new Node(a1.data);
                  anstail=anshead;
              }
              else{
                  anstail.next=new Node(a1.data);
                  anstail=anstail.next;
              }
              a1=a1.next;
              a2=a2.next;
          }
          else if(a1.data<a2.data){
              a1=a1.next;
          }
          else{
              a2=a2.next;
          }
      }
      return anshead;
    }
}