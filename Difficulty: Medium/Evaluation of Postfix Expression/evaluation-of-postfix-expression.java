//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> s1=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].equals("+")){
                int t2=s1.pop();
                int t1=s1.pop();
                s1.push(t1+t2);
            }
            else if(arr[i].equals("-")){
               int t2=s1.pop();
                int t1=s1.pop();
                s1.push(t1-t2);
            }
            else if(arr[i].equals("*")){
                int t2=s1.pop();
                int t1=s1.pop();
                s1.push(t1*t2);
            }
            else if(arr[i].equals("/")){
                int t2=s1.pop();
                int t1=s1.pop();
                s1.push(t1/t2);
            }
            else{
                
                s1.push(Integer.parseInt(arr[i]));
            }
        }
        return s1.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends