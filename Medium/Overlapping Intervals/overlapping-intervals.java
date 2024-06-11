//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here
        int n=Intervals.length;
        Arrays.sort(Intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=Intervals[i][0];
            int end=Intervals[i][1];
            if(ans.size()!=0 && end<=ans.get(ans.size()-1)[1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(Intervals[j][0]<=end){
                    end=(int)Math.max(Intervals[j][1],end);
                }
                else{
                    break;
                }
            }
            int a1[]=new int[2];
            a1[0]=start;
            a1[1]=end;
            ans.add(a1);
            //System.out.println(start+" "+end)
            
        }
        return ans.toArray(new int[ans.size()][]);
        
        
    }
}