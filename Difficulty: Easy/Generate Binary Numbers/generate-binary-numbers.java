//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        //Taking input using class Scanner 
        Scanner sc = new Scanner(System.in);
        
        //Taking the number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking the range
            int n = sc.nextInt();
            
            //creating an ArrayList
            ArrayList<String> res = new ArrayList<String>();
            
            //calling the generate method of class solve
            //and storing the result in an ArrayList
            res = new solve().generate(n);
            
            //printing all the elements of the ArrayList
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        Queue<String> q1=new LinkedList<>();
        if(N==1){
            ans.add("1");
            return ans;
        }
        q1.add("1");
        ans.add(q1.peek());
        int c=1;
        while(c<=N){
            String t1=q1.remove();
            String t2=t1+'0';
            c=c+1;
             ans.add(t2);
            if(c>=N){
                break;
            }
            String t3=t1+'1';
            c=c+1;
           ans.add(t3);
            if(c>=N){
                break;
            }
            q1.add(t2);
            q1.add(t3);
        }
        return ans;
        
    }
    
}
