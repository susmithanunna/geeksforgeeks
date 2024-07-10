//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution g = new Solution();
                int k=g.minDepth(root);
			    System.out.println(k);
	        }
	}
}



// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
	int minDepth(Node root)
	{
	    //code here
	    Queue<Pair> q1=new LinkedList<>();
	    q1.add(new Pair(root,1));
	    int c=0;
	    int ans=Integer.MAX_VALUE;
	    while(!q1.isEmpty()){
	        Pair p=q1.remove();
	        Node curr=p.n;
	        int lev=p.level;
	       
	        if(curr.left!=null){
	           if(curr.left.left==null && curr.left.right==null){
	               ans=(int)Math.min(lev+1,ans);
	           }
	           else{
	               q1.add(new Pair(curr.left,lev+1));
	           }
	        }
	        if(curr.right!=null){
	            if(curr.right.left==null && curr.right.right==null){
	               ans=(int)Math.min(lev+1,ans);
	           }
	           else{
	               q1.add(new Pair(curr.right,lev+1));
	           }
	        }
	       
	    }
	    return ans;
	}
}

class Pair{
    Node n;
    int level;
    public Pair(Node n,int level){
        this.n=n;
        this.level=level;
    }
}
