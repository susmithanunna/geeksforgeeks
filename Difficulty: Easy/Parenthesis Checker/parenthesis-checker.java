//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        int n=s.length();
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='('){
                s1.add(s.charAt(i));
            }
            else if(!s1.isEmpty()){
                if(s1.peek()=='[' && s.charAt(i)==']'){
                    s1.pop();
                }
                else if(s1.peek()=='{' && s.charAt(i)=='}'){
                    s1.pop();
                }
                else if(s1.peek()=='(' && s.charAt(i)==')'){
                    s1.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(s1.isEmpty()){
            return true;
        }
        return false;
    }
}
