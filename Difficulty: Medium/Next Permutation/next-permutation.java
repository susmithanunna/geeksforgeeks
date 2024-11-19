//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
        int minindex=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                minindex=i;
                break;
            }
        }
      if(minindex==-1){
          int i=0;
          int j=n-1;
          while(i<j){
              int t=arr[i];
              arr[i]=arr[j];
              arr[j]=t;
              i++;
              j--;
              
          }
          return;
      }
        for(int i=n-1;i>minindex;i--){
            if(arr[i]>arr[minindex]){
                int t=arr[minindex];
                arr[minindex]=arr[i];
                arr[i]=t;
                break;
            }
        }
       
        int i=minindex+1;
        int j=n-1;
        while(i<=j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
    }
}


// User function Template for Java

// class Solution{
//     static List<Integer> nextPermutation(int N, int arr[]){
//         // code here
//         int index=-1;
//          List<Integer> ans=new ArrayList<>();
//         for(int i=N-2;i>=0;i--){
//             if(arr[i]<arr[i+1]){
//                 index=i;
//                 break;
//             }
//         }
//         if(index==-1){
//             for(int i=N-1;i>=0;i--){
//                 ans.add(arr[i]);
//             }
//             return ans;
//         }
//         for(int i=N-1;i>index;i--){
//             if(arr[i]>arr[index]){
//                 int t=arr[index];
//                 arr[index]=arr[i];
//                 arr[i]=t;
//                 break;
//             }
//         }
       
//         for(int i=0;i<=index;i++){
//             ans.add(arr[i]);
//         }
//         for(int i=N-1;i>index;i--){
//             ans.add(arr[i]);
            
//         }
//         return ans;
//     }
// }

//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends