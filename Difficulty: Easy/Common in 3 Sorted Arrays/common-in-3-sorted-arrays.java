//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.size() == 0) System.out.print(-1);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> a, List<Integer> b,
                                        List<Integer> c) {
        // Code Here
        int n1=a.size();
		int n2=b.size();
		int n3=c.size();
		int i=0;
		int j=0;
		int k=0;
		List<Integer> ans=new ArrayList<>();
		while(i<n1 && j<n2 && k<n3){
			if(a.get(i).equals(b.get(j)) && b.get(j).equals(c.get(k))){
				if(ans.isEmpty() || !ans.get(ans.size()-1).equals(a.get(i)) )
				ans.add(a.get(i));
				i++;
				j++;
				k++;
			}
			else if(a.get(i)<b.get(j) ){
				i++;
			}
			else if(b.get(j)<c.get(k) ){
				j++;
			}
			else{
				k++;
			}
		}
		if(ans.size()==0){
		    ans.add(-1);
		}
		return ans;
    }
}
    