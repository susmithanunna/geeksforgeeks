//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int n, int[] arr) {
        // code here
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<n;i++){
            if(s1.isEmpty()){
                s1.add(arr[i]);
            }
            else if(s1.peek()<0 && arr[i]<0){
                s1.add(arr[i]);
            }
            else if(s1.peek()>0 && arr[i]>0){
                s1.add(arr[i]);
            }
            else if(s1.peek()<0 && arr[i]>0){
                s1.add(arr[i]);
            }
            else if(s1.peek()>0 && arr[i]<0 && (int)Math.abs(s1.peek())<=(int)Math.abs(arr[i])){
                while(!s1.isEmpty()){
                     if(((s1.peek()>0 && arr[i]<0) ||(s1.peek()<0 && arr[i]>0)) && (int)Math.abs(s1.peek())==(int)Math.abs(arr[i])){
                       s1.pop();
                        break;
                    }
                    if(((s1.peek()>0 && arr[i]<0)||( s1.peek()<0 && arr[i]>0)) && (int)Math.abs(s1.peek())<=(int)Math.abs(arr[i])){
                         //System.out.println(s1.peek()+" "+arr[i]);
                        s1.pop();
                        if(s1.isEmpty()){
                            s1.add(arr[i]);
                            break;
                        }
                    }
                    else if((s1.peek()>0 && arr[i]>0)||( s1.peek()<0 && arr[i]<0)){
                        s1.add(arr[i]);
                        break;
                    }
                    else if((int)Math.abs(s1.peek())<=(int)Math.abs(arr[i])){
                        s1.add(arr[i]);
                        break;
                        }
                        else {
                            break;
                        }
                }
                
            }
           
            
        }
        int ans[]=new int[s1.size()];
        for(int i=s1.size()-1;i>=0;i--){
            ans[i]=s1.pop();
        }
        return ans;
    }
}
