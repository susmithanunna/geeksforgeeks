//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        HashMap<Integer,Integer> h1=new HashMap<>();
        int c=0;
        int sum=0;
        h1.put(0,1);
        for(int i=0;i<N;i++){
            sum=sum+Arr[i];
            int t=sum-k;
            if(h1.containsKey(t)){
                c=c+h1.get(t);
                
            }
            if(h1.get(sum)!=null){
                h1.put(sum,h1.get(sum)+1);
            }
            else{
                h1.put(sum,1);
            }
        }
        return c;
        
    }
}