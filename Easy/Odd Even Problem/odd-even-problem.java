//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
       int h1[]=new int[26];
       //System.out.println(s.charAt(0)-'0');
        for(int i=0;i<s.length();i++){
            int c=h1[s.charAt(i)-'a'];
            h1[s.charAt(i)-'a']=c+1;
        }
        int x=0;
        int y=0;
        for(int i=0;i<26;i++){
            if((i+1)%2==0 && h1[i]!=0){
                //System.out.println("even "+h1[i]);
                if(h1[i]%2==0){
                    x=x+1;
                }
            }
            else if((i+1)%2!=0 && h1[i]!=0){
                 
                if(h1[i]%2!=0){
                    y=y+1;
                }
            }
        }
       // System.out.println("x:"+x+" y:"+y);
        if((x+y)%2==0){
            return "EVEN";
        }
        return "ODD";
    }
}
