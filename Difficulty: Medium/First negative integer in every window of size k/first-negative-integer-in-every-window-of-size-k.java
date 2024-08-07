//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int K)
    {
        long ans[]=new long[N-K+1];
        int c=0;
	    ArrayList<Integer> t=new ArrayList<>();
	    for(int i=0;i<K;i++){
	        if(arr[i]<0 ){
	            t.add(i);
	        }
	        
	    }
	    if(t.size()!=0){
	        ans[c]=arr[t.get(0)];
	        //t.remove(t.get(0));
	        c++;
	    }
	    else{
	        ans[c]=0;
	        c++;
	    }
	   
	    for(int i=K;i<N;i++){
	         while(t.size()!=0 && t.get(0)<i-K+1){
	                t.remove(t.get(0));
	            }
	        if(arr[i]<0){
	            t.add(i);
	        }
	        if(t.size()!=0){
	            ans[c]=arr[t.get(0)];
	            c++;
	        }
	        else{
	            ans[c]=0;
	            c++;
	        }
	       
	        
	        
	    }
	    return ans;
    }
}