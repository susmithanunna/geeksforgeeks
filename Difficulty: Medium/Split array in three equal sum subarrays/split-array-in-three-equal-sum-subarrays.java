//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        int sum=0;
       List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
        }
        if(sum%3!=0){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
     //if(find(arr,sum/3)){
         int sum1=0;
         for(int i=0;i<n;i++){
             sum1=sum1+arr[i];
             if(sum1==sum/3){
                 ans.add(i);
                 sum1=0;
                 if(ans.size()==2){
                     return ans;
                 }
             }
         }
         return Arrays.asList(-1,-1);
        
    }
  
}