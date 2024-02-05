//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
           int sum1=0;
	    int sum2=0;
	    int sum3=0;
	    int i1=0;
	    int i2=0;
	    int i3=0;
	    for(int i=0;i<N1;i++){
	        sum1=sum1+S1[i];
	    }
	    for(int i=0;i<N2;i++){
	        sum2=sum2+S2[i];
	    }
	    for(int i=0;i<N3;i++){
	        sum3=sum3+S3[i];
	    }
	    while(i1<N1 && i2<N2 && i3<N3){
	       int max=(int)Math.max(sum1,sum2);
	       max=(int)Math.max(max,sum3);
	       if(sum1==sum2 && sum2==sum3){
	           return sum1;
	       }
	       if(max==sum1){
	         sum1=sum1-S1[i1];
	         if(sum1==0){
	             return 0;
	         }
	         i1++;
	       }
	       else if(max==sum2){
	         sum2=sum2-S2[i2];
	         if(sum2==0){
	             return 0;
	         }
	         i2++;
	       }
	       else if(max==sum3){
	         sum3=sum3-S3[i3];
	         if(sum3==0){
	             return 0;
	         }
	         i3++;
	       }
	        
	    }
	   return 0;
    }
}
        
