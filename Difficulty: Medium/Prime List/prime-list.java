//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node temp=head;
        while(temp!=null){
            if(isPrime(temp.val)){
                temp=temp.next;
            }
            else{
                int prev=prevPrime(temp.val);
                int nex=nextPrime(temp.val);
                //System.out.println(prev+" "+nex+" "+temp.val);
                if(temp.val-prev==nex-temp.val){
                    temp.val=prev;
                    
                }
                else if(temp.val-prev<nex-temp.val){
                    temp.val=prev;
                }
                else{
                    temp.val=nex;
                }
                temp=temp.next;
            }
        }
        return head;
    }
    int prevPrime(int n){
        for(int i=n-1;i>=2;i--){
            if(isPrime(i)){
                return i;
            }
        }
        return -1;
    }
    int nextPrime(int n){
        for(int i=n+1;;i++){
            if(isPrime(i)){
                return i;
            }
        }
        //return -1;
    }
    boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}