//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(b.dis,a.dis));
        int n=points.length;
        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int x2=points[i][1];
            int dis=euclideanDistance(x1,x2);
            pq.add(new Pair(x1,x2,dis));
            while(pq.size()>k){
                pq.remove();
            }
        }
        int ans[][]=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            ans[i][0]=p.x1;
            ans[i][1]=p.x2;
            i++;
        }
        return ans;
    }
    public int euclideanDistance(int x1,int x2){
        return (int)Math.sqrt((x1*x1)+(x2*x2));
    }
    
}
class Pair{
    int x1;
    int x2;
    int dis;
    public Pair(int x1,int x2,int dis){
        this.x1=x1;
        this.x2=x2;
        this.dis=dis;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends