//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        Job arr[]=new Job[n];
        for(int i=0;i<n;i++){
            arr[i]=new Job(i,deadline[i],profit[i]);
        }
        Arrays.sort(arr,(a,b)->Integer.compare(b.profit,a.profit));
        int maxdeadline=0;
        for(int i=0;i<n;i++){
            if(maxdeadline<arr[i].deadline){
                maxdeadline=arr[i].deadline;
            }
        }
        boolean take[]=new boolean[n];
        int c=0;
        int pro=0;
        for(int i=0;i<n;i++){
            for(int j=(int)Math.min(n,arr[i].deadline-1);j>=0;j--){
                if(take[j]==false){
                    c++;
                    pro=pro+arr[i].profit;
                    take[j]=true;
                    break;
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(c);
        ans.add(pro);
        return ans;
        
    }
    class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends