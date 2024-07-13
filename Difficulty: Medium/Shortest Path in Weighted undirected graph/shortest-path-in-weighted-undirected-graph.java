//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
              ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int parent[]=new int[n+1];
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        int vis[]=new int[n+1];
        //parent[1]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((p1,p2)->p1.dis-p2.dis);
        pq.add(new Pair(0,1));
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int node=p.vertex;
            int distance=p.dis;
            if(vis[node]==1){
                continue;
            }
            vis[node]=1;
            for(Pair it:adj.get(node)){
                int adjnode=it.dis;
                int adjdis=it.vertex;
                if(distance+adjdis<dist[adjnode]){
                    dist[adjnode]=distance+adjdis;
                    pq.add(new Pair(distance+adjdis,adjnode));
                    parent[adjnode]=node;
                }
            }
        }
         
        List<Integer> ans=new ArrayList<>();
        
        if(dist[n]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
  
      int node=n;
         while (parent[node] != node) { // Correct backtracking logic
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        ans.add(dist[n]);
      // System.out.println(ans);
        Collections.reverse(ans);
        return ans;

    }
}
class Pair{
    int dis;
    int vertex;
    public Pair(int dis,int vertex){
        this.dis=dis;
        this.vertex=vertex;
    }
}
