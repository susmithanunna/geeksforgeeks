//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    String list[] = new String[n];
                    for(int i = 0;i<n;i++)
                        list[i] = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.countWords(list, n));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWords(String list[], int n)
    {
        // code here 
        HashMap<String,Integer> h1=new HashMap<>();
        Integer c;
        for(int i=0;i<n;i++){
            c=h1.get(list[i]);
            if(c==null){
                c=0;
            }
            h1.put(list[i],c+1);
        }
        int count=0;
        for(String i:h1.keySet()){
            if(h1.get(i)==2){
                count++;
            }
        }
        return count;
    }
}