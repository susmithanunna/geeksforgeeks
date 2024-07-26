//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        HashSet<Character> h1=new HashSet<>();
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                h1.add(str.charAt(i));
                c++;
            }
        }
       //System.out.println("h1 size "+h1.size()+" c:"+c);
       int t1=c-h1.size();
       int t2=26-h1.size();
       //System.out.println(t1+" "+t2);
        if(h1.size()==26){
            return true;
        }
        else if(26-h1.size()<=c-h1.size() && t2<=k){
            return true;
        }
        return false;
    }
}