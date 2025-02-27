//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    Stack<Integer> s1;
    int min;
    public Solution() {
        s1=new Stack<>();
        min=-1;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        if(s1.isEmpty()){
            min=x;
            s1.push(x);
        }
        else{
           if(min<=x){
              s1.push(x);
            }
           else{
               int t=2*x-min;
               s1.push(t);
               min=x;
            } 
        }
        
        
    }

    // Remove the top element from the Stack
    public void pop() {
        // code here
        if(s1.isEmpty()){
            return;
        }
        if(s1.peek()<min){
            min=2*min-s1.peek();
        }
        s1.pop();
        
    }

    // Returns top element of the Stack
    public int peek() {
        // code here
        
        if(s1.isEmpty()){
            return -1;
        }
        if(s1.peek()>=min){
            return s1.peek();
        }
        return min;
    }

    // Finds minimum element of Stack
    public int getMin() {
        // code here
        if(s1.isEmpty()){
            return -1;
        }
        return min;
    }
}
//2 1 