//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        ArrayList<Pair> a1=new ArrayList<>();
        int n=arr.length;
        HashMap<Integer,Integer> h1=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        Integer c;
        for(int i=0;i<n;i++){
            c=h1.get(arr[i]);
            if(c==null){
                c=0;
            }
            h1.put(arr[i],c+1);
        }
        for(int it:h1.keySet()){
            a1.add(new Pair(it,h1.get(it)));
        }
        Collections.sort(a1,(a,b)->{
            if(a.f!=b.f){
                return Integer.compare(b.f,a.f);
            }
            else{
                return Integer.compare(a.n,b.n);
            }
        });
        for(int i=0;i<a1.size();i++){
            for(int j=0;j<a1.get(i).f;j++){
                ans.add(a1.get(i).n);
            }
        }
        return ans;
    }
}
class Pair{
    int n;
    int f;
    public Pair(int n,int f){
        this.n=n;
        this.f=f;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends