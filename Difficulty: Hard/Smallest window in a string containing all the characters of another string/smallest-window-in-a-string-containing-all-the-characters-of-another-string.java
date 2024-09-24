//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int n=s.length();
        int m=p.length();
        int arr2[]=new int[26];
        int arr1[]=new int[26];
        for(int i=0;i<m;i++){
            arr2[p.charAt(i)-'a']++;
        }
        int j=0;
        int i=0;
        String ans="";
        int match=0;
        while(j<n){
            char ch=s.charAt(j);
            arr1[ch-'a']++; 
            if(arr1[ch-'a']<=arr2[ch-'a']){
                match++;
            }
            while(match==m){
                if(ans.length()==0 || j-i+1<ans.length()){
                    ans=s.substring(i,j+1);
                }
                ch=s.charAt(i);
                arr1[ch-'a']--;
                if(arr1[ch-'a']<arr2[ch-'a']){
                    match--;
                }
                i++;
            }
            j++;
        }
        return ans.length()==0?"-1":ans;
        
    }
    
}