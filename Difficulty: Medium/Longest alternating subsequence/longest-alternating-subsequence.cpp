//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int AlternatingaMaxLength(vector<int>& nums) {
        // Code here
        int n=nums.size();
        int dp[n][2];
        dp[0][0]=1;
        dp[0][1]=1;
        if(n==1){
            return 1;
        }
        for(int i=1;i<nums.size();i++){
            //for(int j=0;j<2;j++){
            //count<<dp[i-1]
                if(nums[i-1]<nums[i]){
                    dp[i][0]=1+dp[i-1][1];
                    dp[i][1]=dp[i-1][1];
                }
                else if(nums[i-1]>nums[i]){
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=dp[i-1][0]+1;
                    
                }
                else{
                    dp[i][0]=dp[i-1][0];
                    dp[i][1]=dp[i-1][1];
                }
            //}
        }
        if(dp[n-1][1]>=dp[n-1][0]){
             return dp[n-1][1];
        }
        return dp[n-1][0];
       
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n;
        cin >> n;
        vector<int> nums(n);
        for (int i = 0; i < n; i++)
            cin >> nums[i];
        Solution obj;
        int ans = obj.AlternatingaMaxLength(nums);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends