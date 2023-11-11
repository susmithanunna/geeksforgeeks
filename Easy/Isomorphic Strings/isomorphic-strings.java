//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // if(str1.length()!=str2.length()){
        //     return false;
        // }
        // int c=0;
        // for(int i=0;i<str1.length()-1;i++){
        //     if(str1.charAt(i)==str1.charAt(i+1)){
        //         if(str2.charAt(i)!=str2.charAt(i+1)){
        //             return false;
        //         }
        //     }
        //     else{
        //       if(str2.charAt(i)==str2.charAt(i+1)){
        //             return false;
        //         } 
        //     }
            
        // }
        // LinkedHashMap<Character,Integer> l1=new LinkedHashMap<>();
        // LinkedHashMap<Character,Integer> l2=new LinkedHashMap<>();
        // Integer c1;
        // for(int i=0;i<str1.length();i++){
        //     c1=l1.get(str1.charAt(i));
        //     if(c1==null){
        //         c1=0;
        //     }
        //     l1.put(str1.charAt(i),c1+1);
        // }
        // for(int i=0;i<str2.length();i++){
        //     c1=l2.get(str2.charAt(i));
        //     if(c1==null){
        //         c1=0;
        //     }
        //     l2.put(str2.charAt(i),c1+1);
        // }
        // if(l1.size()!=l2.size()){
        //     return false;
        // }
        // return true;
        if(str1.length()!=str2.length()){
            return false;
        }
        LinkedHashMap<Character,Character> l1=new LinkedHashMap<>();
        LinkedHashMap<Character,Character> l2=new LinkedHashMap<>();
        char c='o';
        for(int i=0;i<str1.length();i++){
            char c1=str1.charAt(i);
            char c2=str2.charAt(i);
            if(l1.containsKey(c1)){
                c=l1.get(c1);
                if(c!=c2){
                    return false;
                }
            }
            else{
                l1.put(c1,c2);
            }
            if(l2.containsKey(c2)){
                c=l2.get(c2);
                if(c!=c1){
                    return false;
                }
            }
            else{
                l2.put(c2,c1);
            }
            
        }
        return true;
        
    }
}