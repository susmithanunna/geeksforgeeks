//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        //ArrayList<String> a1=new ArrayList<>();
        int n1=s.length();
        int dp[]=new int[n1+1];
        dp[0]=1;
        int max=0;
        for(int i=0;i<dictionary.size();i++){
            max=(int)Math.max(max,dictionary.get(i).length());
        }
        for(int i=0;i<=n1;i++){
            for(int j=0;j<i;j++){
                if(i-j>max){
                    continue;
                }
                if(dp[j]==1 && dictionary.contains(s.substring(j,i))){
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[n1];
     
    }
}