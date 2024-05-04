//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        if(in.length!=post.length || in.length==0 || post.length==0){
            return null;
        }
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<n;i++){
            h1.put(in[i],i);
        }
        return constructbinaryTree(in,0,n-1,post,0,n-1,h1);
    }
    Node constructbinaryTree(int in[],int is,int ie,int post[],int ps,int pe,HashMap<Integer,Integer>h1){
        if(is>ie || ps>pe){
            return null;
        }
        Node root=new Node(post[pe]);
        int index=h1.get(post[pe]);
        int numsleft=index-is;
        root.left=constructbinaryTree(in,is,index-1,post,ps,ps+numsleft-1,h1);
        root.right=constructbinaryTree(in,index+1,ie,post,ps+numsleft,pe-1,h1);
        return root;
    }
}
