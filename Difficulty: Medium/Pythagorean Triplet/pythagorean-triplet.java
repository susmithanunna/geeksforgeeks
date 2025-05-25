class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n=arr.length;
       HashMap<Integer,Integer> h1=new HashMap<>();
       for(int i=0;i<n;i++){
           int sqr=arr[i]*arr[i];
           for(int j=0;j<n;j++){
               if(j==sqr){
                   continue;
               }
               if(h1.containsKey(sqr-(arr[j]*arr[j]))){
                   return true;
               }
               if(h1.containsKey(arr[j]*arr[j])){
                   h1.put(arr[j]*arr[j],h1.get(arr[j]*arr[j])+1);
               }
               else{
                   h1.put(arr[j]*arr[j],1);
               }
           }
       }
       return false;
      
    }
}