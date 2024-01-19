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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here

          ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Update frequency map
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            // Use a PriorityQueue to maintain the top K most frequent numbers
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? Integer.compare(a.getKey(), b.getKey()) : Integer.compare(b.getValue(), a.getValue())
            );

            // Populate the PriorityQueue with entries from the frequency map
            pq.addAll(frequencyMap.entrySet());

            // Create a list to store the top K numbers for the current iteration
            ArrayList<Integer> topKList = new ArrayList<>();
            int count = Math.min(K, pq.size());

            // Add the top K numbers to the list
            for (int j = 0; j < count; j++) {
                topKList.add(pq.poll().getKey());
            }

            // Add the list to the result array
            result.add(topKList);
        }

        return result;

        // Print the result
    }
}
        
