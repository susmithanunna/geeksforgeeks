class Solution {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        // for (int i = 0; i<n; i++){
        //     for(int j=i+1; j<n; j++) {
        //         int min = Integer.MAX_VALUE;
        //         int max = Integer.MIN_VALUE;
        //         for (int k=i;k<=j;k++) {
        //             max = (int)Math.max(max,arr[k]);
        //             min = (int)Math.min(min,arr[k]);
        //         }
        //         ans_max=(int)Math.max(max+min,ans_max);
        //     }
        // }
        
        for(int i=1;i<n;i++){
            max=(int)Math.max(arr[i-1]+arr[i],max);
        }
        return max;
    }
}