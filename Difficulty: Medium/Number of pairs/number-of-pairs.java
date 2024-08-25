//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        long c=0;
        Arrays.sort(y);
        int county[]=new int[5];
        for(int i=0;i<N;i++){
            if(y[i]<5){
                county[y[i]]++;
            }
        }
        for(int i=0;i<M;i++){
            if(x[i]==0){
                continue;
            }
            if(x[i]==1){
                c=c+county[0];
                continue;
            }
            long pos=upperbound(y,x[i]);
            c=c+(N-pos)+county[0]+county[1];
            if(x[i]==2){
                c=c-(county[3]+county[4]);
            }
            if(x[i]==3){
                c=c+(county[2]);
            }
        }
       return c;
    }
    public long upperbound(int y[],int val){
        int l=0;
        int r=y.length;
        while(l<r){
            int mid=(l+r)/2;
            if(y[mid]<=val){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}