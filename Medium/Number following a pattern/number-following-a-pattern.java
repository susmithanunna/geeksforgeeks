//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
       Stack<Integer> s1=new Stack<>();
       String ans="";
       int c=1;
    //   if(S.length()==1 ){
    //       if(S.charAt(0)=='D'){
    //           return "21";
    //       }
    //       else{
    //           return "34";
    //       }
    //   }
    for(int i=0;i<S.length();i++){
        s1.push(c);
        c++;
        if(S.charAt(i)=='I'){
            //s1.push(c);
            while(!s1.isEmpty()){
            ans=ans+Integer.toString(s1.pop());
            }
        }
    }
    s1.push(c);
        while(!s1.isEmpty()){
            ans=ans+Integer.toString(s1.pop());
        }
    
    return ans;

    }
}
