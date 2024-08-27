//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n=arr.length;
        int ls[]=new int[n];
        int rs[]=new int[n];
        int min=arr[0];
        ls[0]=0;
        Stack<Integer> s1=new Stack<>();
        for(int i=1;i<n;i++){
            if(arr[i-1]==arr[i]){
                ls[i]=ls[i-1];
            }
           else if(arr[i-1]<arr[i]){
               min=arr[i-1];
               ls[i]=min;
               s1.add(min);
               
           }
           else if(arr[i-1]>arr[i] && !s1.isEmpty() &&  s1.peek()<arr[i]){
               ls[i]=s1.peek();
           }
           else if(arr[i-1]>arr[i]){
               while(!s1.isEmpty() && s1.peek()>=arr[i]){
                   s1.pop();
               }
               //System.out.println("the current "+s1+" i "+i);
                if(!s1.isEmpty()){
                    ls[i]=s1.peek();
                }
                else{
                    ls[i]=0;
                }
              
           }
           //System.out.println(s1);
        }
        rs[n-1]=0;
        min=arr[n-1];
        Stack<Integer> s2=new Stack<>();
       // System.out.println("s2------");
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]==arr[i]){
                rs[i]=rs[i+1];
            }
            else if(arr[i+1]<arr[i]){
                min=arr[i+1];
                rs[i]=min;
                s2.add(min);
            }
            else if(arr[i+1]>arr[i] && !s2.isEmpty() && s2.peek()<arr[i]){
                rs[i]=s2.peek();
            }
            else if(arr[i+1]>arr[i]){
                while(!s2.isEmpty() && s2.peek()>=arr[i]){
                    s2.pop();
                }
                if(s2.isEmpty()){
                    rs[i]=0;
                }
                else{
                    rs[i]=s2.peek();
                }
                
            }
             //System.out.println(s2);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           // System.out.print(ls[i]+" ");
            int t=(int)Math.abs(ls[i]-rs[i]);
            max=(int)Math.max(t,max);
        }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.print(rs[i]+" ");
        // }
        //  System.out.println();
        return max;
    }
}
