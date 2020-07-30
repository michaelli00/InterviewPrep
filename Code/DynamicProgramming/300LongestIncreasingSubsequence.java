// Given an unsorted array of integers, find the length of longest 
// increasing subsequence. Note: the subsequence does NOT have to be 
// contiguous
class Solution {
  // DP bottom-up: Idea is to try to keep track of the longest subsequence
  // including element i in dp[i] as the last element. We do this by 
  // finding the largest subsequence dp[j] where nums[i] > nums[j] and 
  // setting dp[i] = dp[j] + 1. We keep another variable ans to keep track
  // of the global maximum length
  public int lengthOfLIS(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int ans = 1;
    for(int i = 1; i < dp.length; i++) {
      int val = 0;
      for(int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          val = Math.max(val, dp[j]);
        }
        dp[i] = val + 1;
        ans = Math.max(ans, dp[i]);
      }
    }
    return ans;
  }
}
