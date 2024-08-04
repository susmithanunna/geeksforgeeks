//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        ArrayList<Pair> a1=new ArrayList<>();
        for(int i=0;i<n;i++){
            a1.add(new Pair(start[i],end[i]));
        }
        Collections.sort(a1,(a,b)->Integer.compare(a.e,b.e));
        int c=0;
        int prev=0;
        for(int i=0;i<n;i++){
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
