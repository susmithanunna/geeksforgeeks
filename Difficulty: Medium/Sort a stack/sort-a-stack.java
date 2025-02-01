//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        sortTheStack(s);
        return s;
    }
    public void sortTheStack(Stack<Integer> s){
        if(s.size()==0){
            return;
        }
        int temp=s.pop();
        sortTheStack(s);
        insert(s,temp);
        return;
    }
    public void insert(Stack<Integer> s,int val){
        if(s.size()==0 || s.peek()<=val){
            s.push(val);
            return;
        }
        int temp=s.pop();
        insert(s,val);
        s.push(temp);
        return;
    }
}