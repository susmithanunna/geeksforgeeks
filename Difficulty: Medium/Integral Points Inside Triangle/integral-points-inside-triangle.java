//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long InternalCount(long p[], long q[], long r[]) {
        // code here
        long area=Math.abs(p[0]*(q[1]-r[1])+q[0]*(r[1]-p[1])+r[0]*(p[1]-q[1]))/2;
        long points=gcd(Math.abs(p[0]-q[0]),Math.abs(p[1]-q[1]))
        +gcd(Math.abs(q[0]-r[0]),Math.abs(q[1]-r[1]))
        +gcd(Math.abs(r[0]-p[0]),Math.abs(r[1]-p[1]));
        return area+1-(points/2);
    }
    long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
};
//p1,p2), (q1,q2), (r1,r2):
// Area (A) = mod (p1*(q2 - r2) + q1*(r2 - p2) + r1*(p2 - q2)) / 2
//Boundary Points (P) = gcd (mod (p1 - q1) , mod (p2 - q2)) + gcd (mod (q1 - r1) ,mod (q2 - r2)) + gcd (mod (r1 - p1) , mod (r2 - p2)
//A=1/2(P+I-1)
//p--->no.of boundary lattice points
//I--> no.of interior lattice points
//A-->area of triangle