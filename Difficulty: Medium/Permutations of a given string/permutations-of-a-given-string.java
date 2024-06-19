//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> ans=new ArrayList<>();
        int n=S.length();
        solve(S,0,ans);
        Collections.sort(ans);
        return ans;
    }
    public void solve(String S,int index,List<String> ans){
        if(index==S.length()){
            if(!ans.contains(S)){
                   ans.add(S);
            }
            return;
        }
        for(int j=index;j<S.length();j++){
            S=swap(S,index,j);
            solve(S,index+1,ans);
            S=swap(S,index,j);
        }
    }
    public String swap(String S,int index,int j){
        StringBuilder t=new StringBuilder(S);
        char t1=S.charAt(index);
        char t2=S.charAt(j);
        
        t.setCharAt(index,t2);
        t.setCharAt(j,t1);
        return t.toString();
        
        
    }
}