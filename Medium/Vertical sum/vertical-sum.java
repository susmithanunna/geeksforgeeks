//{ Driver Code Starts
//Initial Template for Java

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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Tuple{
    Node node;
    int vertical;
    int level;
    public Tuple(Node node,int vertical,int level){
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
}
class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q1=new LinkedList<>();
        q1.add(new Tuple(root,0,0));
        while(!q1.isEmpty()){
            Tuple t=q1.remove();
            Node temp=t.node;
            int verti=t.vertical;
            int lev=t.level;
            if(!map.containsKey(verti)){
                map.put(verti,new TreeMap<>());
            }
            if(!map.get(verti).containsKey(lev)){
                map.get(verti).put(lev,new PriorityQueue<>());
            }
            map.get(verti).get(lev).add(temp.data);
            if(temp.left!=null){
                q1.add(new Tuple(temp.left,verti-1,lev+1));
            }
            if(temp.right!=null){
                q1.add(new Tuple(temp.right,verti+1,lev+1));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> it1:map.values()){
            int sum=0;
            for(PriorityQueue<Integer> it2:it1.values()){
                while(!it2.isEmpty()){
                    sum=sum+it2.remove();
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
