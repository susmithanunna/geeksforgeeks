//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> temp=new ArrayList<>();
    public boolean checkSorted(List<Integer> arr) {
        // code here
       int n=arr.size();
       int c=0;
      // int arr[]=new int[n];
       for(int i=0;i<n;i++){
           while(arr.get(i)!=i+1){
               int t1=arr.get(i);
               int t2=arr.get(t1-1);
               arr.set(t1-1,arr.get(i));
               arr.set(i,t2);
               c++;
               if(c>2){
                   return false;
                }
           }
           
       }
      
       return c==0||c==2;
    }
    
}