//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)>='0'  && S.charAt(i)<='9'){
                s1.add(S.charAt(i)-'0');
            }
            else{
                int y=s1.pop();
                int x=s1.pop();
                if(S.charAt(i)=='*'){
                    s1.add(x*y);
                }
                else if(S.charAt(i)=='/'){
                    s1.add(x/y);
                }
                else if(S.charAt(i)=='+'){
                    s1.add(x+y);
                }
                else{
                    s1.add(x-y);
                }
            }
            
        }
        return s1.peek();
    }
}