//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        // Your code here
        int n=s.length();
        int i=0;
        long ans=0;
        boolean flag=false;
        while(i<n){
            while(i<n && (s.charAt(i)==' ' || s.charAt(i)=='0') && ans==0){
                 //System.out.println(i);
                i++;
            }
           
           if(i>n-1){
               break;
           }
            if(s.charAt(i)=='-' && ans==0){
                flag=true;
                i++;
                continue;
            }
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                 ans=ans*10+(s.charAt(i)-'0');
                i++;
            }
            else{
                break;
            }
        }
        //System.out.println(ans);
        if(flag==true){
            ans=-1*ans;
        }
        if(ans>Integer.MAX_VALUE){
            return 2147483647;
        }
        if(ans<Integer.MIN_VALUE){
            return -2147483648;
        }
        return (int)ans;
    }
}