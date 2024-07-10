//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String s) 
    { 
        // code here
        HashMap<Integer,Integer> h1=new HashMap<>();
        int ans=0;
        int c=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                c=c-1;
                if(c==0){
                    ans++;
                }
            }
            else{
                c=c+1;
                if(c==0){
                    ans++;
                }
            }
            if(c==0){
                if(h1.containsKey(c)){
                    ans=ans+h1.get(c);
                    h1.put(c,h1.get(c)+1);
                }
                else{
                   // ans=ans+1;
                    h1.put(c,1);
                }
            }
            else{
                if(h1.containsKey(c)){
                    ans=ans+h1.get(c);
                    h1.put(c,h1.get(c)+1);
                }
                else{
                    h1.put(c,1);
                }
            }
              
            
        }
        return ans;
    }
} 
