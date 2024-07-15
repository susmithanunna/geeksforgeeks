//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            Vector<String> v = new Vector<>(); 
            for (int i = 0; i < n; i++) {
                v.addElement(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.removeConsecutiveSame(v));
            
        }
	}
}


// } Driver Code Ends



class Solution 
{
      
    static int removeConsecutiveSame(Vector <String > v) 
    {
        // Your code goes here
        Stack<String> s1=new Stack<>();
        for(int i=0;i<v.size();i++){
            if(s1.isEmpty()){
                s1.add(v.get(i));
            }
            else if(s1.peek().equals(v.get(i))){
                s1.pop();
            }
            else{
                s1.add(v.get(i));
            }
        }
        return s1.size();
    }
}