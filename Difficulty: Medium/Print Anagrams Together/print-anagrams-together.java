//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        int n=arr.length;
        HashMap<String,ArrayList<String>> h1=new HashMap<>();
        for(int i=0;i<n;i++){
            char a1[]=arr[i].toCharArray();
            Arrays.sort(a1);
            String s=new String(a1);
            
            if(h1.containsKey(s)){
                h1.get(s).add(arr[i]);
            }
            else{
                ArrayList<String> l1=new ArrayList<>();
                l1.add(arr[i]);
                h1.put(s,l1);
            }
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(String s1:h1.keySet()){
            ans.add(h1.get(s1));
        }
        return ans;
        
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends