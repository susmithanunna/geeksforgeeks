//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if(d*9<s){
            return "-1";
        }
        //int digits[]=new int[d];
        String ans="";
        s=s-1;
        for(int i=d-1;i>0;i--){
            if(s>=9){
                ans="9"+ans;
                s=s-9;
            }
            else{
                ans=String.valueOf(s)+ans;
                s=0;
            }
        }
        int t=1+s;
        return String.valueOf(t)+ans;
        
    }
}
