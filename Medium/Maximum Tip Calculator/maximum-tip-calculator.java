//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        long tips=0;
       int ans[][]=new int[n][3];
        for(int i=0;i<n;i++){
            ArrayList<Integer> a1=new ArrayList<>();
            int t=(int)Math.abs(arr[i]-brr[i]);
            ans[i][0]=arr[i];
            ans[i][1]=brr[i];
            ans[i][2]=t;
        }
        Arrays.sort(ans,(a,b)->b[2]-a[2]);
        // for(int i=0;i<n;i++){
        //     int ind=ans.get(i).get(1);
        //     if((x1<x && arr[ind]>=brr[ind]) || y1>=y){
        //         tips=tips+arr[ind];
        //         ++x1;
        //     }
        //     else {
        //         tips=tips+brr[ind];
        //         ++y1;
        //     }
        // }
        for(int i=0;i<n;i++){
            if(x==0){ //no elements in arr
                tips=tips+ans[i][1];
                y--;
            }
            else if(y==0){ //no elements in brr
                tips=tips+ans[i][0];
                x--;
            }
            else{
                if(ans[i][0]>ans[i][1]){
                    tips=tips+ans[i][0];
                    x--;
                }
                else{
                    tips=tips+ans[i][1];
                    y--;
                }
            }
           
        }
      return tips;
        
    }
}
