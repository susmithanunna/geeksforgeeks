//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n=arr.length;
        int max=0;
        Stack<Integer> s1=new Stack<>();
        int i=0;
        while(i<n){
            if(s1.isEmpty() || arr[s1.peek()]<=arr[i]){
                s1.add(i);
                i++;
            }
            else{
                int t=s1.pop();
                int tarea=s1.isEmpty()?i*(arr[t]):(i-s1.peek()-1)*arr[t];
                max=(int)Math.max(tarea,max);
            }
           
            
        }
        while(!s1.isEmpty()){
            int t=s1.pop();
            int tarea=s1.isEmpty()?i*(arr[t]):(i-s1.peek()-1)*arr[t];
            max=(int)Math.max(tarea,max);
        }
        return max;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends