//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
    int n=accounts.size();
    DisjointSet ds=new DisjointSet(n);
    
    HashMap<String,Integer> h1=new HashMap<>();
    for(int i=0;i<n;i++){
        for(int j=1;j<accounts.get(i).size();j++){
            String mail=accounts.get(i).get(j);
            if(!h1.containsKey(mail)){
                h1.put(mail,i);
            }
            else{
                ds.unionBysize(i,h1.get(mail));
            }
        }
    }
    List<List<String>> mails=new ArrayList<>();
    for(int i=0;i<n;i++){
        mails.add(new ArrayList<>());
    }
    for(Map.Entry it:h1.entrySet()){
        int parent=ds.findParent((int)it.getValue());
        mails.get(parent).add((String)it.getKey());
    }
    //List<List<String>> ans=new ArrayList<>();
    for(int j=0,i=0;i<mails.size();){
        if(mails.get(i).size()!=0){
            Collections.sort(mails.get(i));
            mails.get(i++).add(0,accounts.get(j++).get(0));
        }
        else{
            mails.remove(i);
            j++;
        }
        
    }
    return mails;

  }
}
class DisjointSet{
    int parent[];
    int size[];
    public DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findParent(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findParent(parent[node]);
    }
    
     public void unionBysize(int u,int v){
         int up=findParent(u);
         int vp=findParent(v);
        //  if(size[up]==size[vp]){
        //      return;
        //  }
         if(size[up]<size[vp]){
             parent[up]=vp;
             size[vp]=size[vp]+size[up];
         }
         else{
             parent[vp]=up;
             size[up]=size[up]+size[vp];
         }
         
     }
    
}
     