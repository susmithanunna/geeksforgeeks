//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n=start.length;
        ArrayList<Pair> a1=new ArrayList<>();
        for(int i=0;i<n;i++){
            a1.add(new Pair(start[i],end[i]));
        }
        Collections.sort(a1,(a,b)->Integer.compare(a.e,b.e));
        int c=1;
        int prev=a1.get(0).e;
        for(int i=1;i<n;i++){
            if(prev<a1.get(i).s){
                prev=a1.get(i).e;
                c++;
            }
           
        }
        return c;
    }
}
class Pair{
    int s;
    int e;
    public Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}

// 1 2
// 3 4
// 0 6
// 5 7
// 8 9
// 5 9
