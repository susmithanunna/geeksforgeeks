//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        long maxNeg=Integer.MIN_VALUE;
        long pro=1;
        int mod=(int)Math.pow(10,9)+7;
        int n=arr.size();
        for(int i=0;i<n;i++){
            if(arr.get(i)!=0){
                pro=(pro*arr.get(i))%mod;
            }
            if(arr.get(i)<0){
                maxNeg=(int)Math.max(maxNeg,arr.get(i));
            }
            
           
        }
       return pro<0?(pro/maxNeg):pro;
    }
}