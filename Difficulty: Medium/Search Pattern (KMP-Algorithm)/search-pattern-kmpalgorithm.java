//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
           int n=text.length();
	    int m=pattern.length();
         int lps[]=new int[m];
         ArrayList<Integer> ans=new ArrayList<>();
	    computeLps(pattern,m,lps);
	    int i=0;
	    int j=0;
	    while((n-i)>=(m-j)){
	        if(pattern.charAt(j)==text.charAt(i)){
	            i++;
	            j++;
	        }
	        if(j==m){
	           // System.out.println("pattern found at "+(i-j));
	           ans.add(i-j+1);
	            j=lps[j-1];
	        }
	        else if(i<n && pattern.charAt(j)!=text.charAt(i)){
	            if(j!=0){
	                j=lps[j-1];
	                
	            }
	            else{
	                i++;
	            }
	        }
	    }
	    return ans;
    }
    void computeLps(String pattern,int m,int lps[]){
	    int len=0;
	    int i=1;
	    lps[0]=0;
	    while(i<m){
	        if(pattern.charAt(len)==pattern.charAt(i)){
	            len++;
	            lps[i]=len;
	            i++;
	        }
	        else{
	            if(len>0){
	                len=lps[len-1];
	                
	            }
	            else{
	                lps[i]=0;
	                i++;
	            }
	        }
	    }
	}
}