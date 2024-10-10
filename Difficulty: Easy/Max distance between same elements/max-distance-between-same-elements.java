//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int maxDistance(int[] arr) {
        // Code here
        int max=Integer.MIN_VALUE;
       HashMap<Integer,Pair> a1=new HashMap<>();
       for(int i=0;i<arr.length;i++){
           if(a1.containsKey(arr[i])){
                Pair p1=a1.get(arr[i]);
                p1.s=i;
                a1.put(arr[i],p1);
           }
           else{
               Pair p1=new Pair(i,-1);
               a1.put(arr[i],p1);
           }
       }
       for(Integer it:a1.keySet()){
           Pair p1=a1.get(it);
           if(p1.s!=-1){
               max=(int)Math.max((int)Math.abs(p1.s-p1.f),max);
           }
           
       }
       return max;
        
    }
}
class Pair{
    int f;
    int s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends