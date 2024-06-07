//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
    //   HashMap<Integer,Integer> h1=new HashMap<>();
    //     Integer c;
    //     for(int i=0;i<n;i++){
    //         for(int j=l[i];j<r[i];j++){
    //           c=h1.get(j);
    //             if(c==null){
    //                 c=0;
    //             }
    //             h1.put(j,c+1);
    //         }
    //     }
    //     int ans=0;
    //     int c1=Integer.MIN_VALUE;
    //     for(Integer i:h1.keySet()){
    //         System.out.println(i+" "+h1.get(i));
    //         if(c1<h1.get(i)){
    //             c1=h1.get(i);
    //             ans=i;
    //         }
    //         // else if(c1==h1.get(i)){
    //         //     if(ans>i){
    //         //         ans=i;
    //         //     }
    //         // }
    //     }
    //     return ans;
    int a1[]=new int[maxx+2];
    for(int i=0;i<n;i++){
       a1[l[i]]++;
       if(r[i]+1<=maxx){
           a1[r[i]+1]--;
       }
    }
    int t1=a1[0];
    int ans=0;
    for(int i=1;i<=maxx;i++){
       // System.out.println(i+" "+ans[i]);
       a1[i]=a1[i]+a1[i-1];
       if(t1<a1[i]){
           t1=a1[i];
           ans=i;
       }
       
    }
        return ans;
    }
}

//{ Driver Code Starts.

// } Driver Code Ends