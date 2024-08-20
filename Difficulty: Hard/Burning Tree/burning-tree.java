//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node,Node> parent=new HashMap<>();
        Queue<Node> q1=new LinkedList<>();
        HashSet<Node> vis=new HashSet<>();
        int ans=0;
        Node tar=null;
        q1.add(root);
        while(!q1.isEmpty()){
            Node temp=q1.remove();
            if(temp.left!=null){
                q1.add(temp.left);
                parent.put(temp.left,temp);
            }
            if(temp.right!=null){
                q1.add(temp.right);
                parent.put(temp.right,temp);
            }
            if(temp.data==target){
                tar=temp;
            }
        }
        q1.add(tar);
        vis.add(tar);
        while(!q1.isEmpty()){
            int n=q1.size();
            int flag=0;
            while(n!=0){
                Node temp=q1.remove();
                if(temp.left!=null && !vis.contains(temp.left)){
                    q1.add(temp.left);
                    flag=1;
                    vis.add(temp.left);
                }
                if(temp.right!=null && !vis.contains(temp.right)){
                    q1.add(temp.right);
                    flag=1;
                    vis.add(temp.right);
                }
                if(parent.get(temp)!=null && !vis.contains(parent.get(temp))){
                    q1.add(parent.get(temp));
                    flag=1;
                    vis.add(parent.get(temp));
                }
                n--;
            }
            if(flag==1){
                ans++;
            }
        }
        return ans;
    }
}