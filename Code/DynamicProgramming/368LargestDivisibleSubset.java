// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

// Si % Sj = 0 or Sj % Si = 0.

// If there are multiple solutions, return any subset is fine.

import java.util.*;
class Solution {
  // bottom-up DP: We know that if i is divisible by the largest number in a set, then it must be divisible by the rest of them
  // Sort the array so we can do this check
  // dp[i] will represent the largest set containing element i
  public List<Integer> largestDivisibleSubset(int[] nums) {
    if(nums.length == 0) return new ArrayList<>();
    
    List<Integer>[] dp = new List[nums.length];
    for(int i = 0; i < dp.length; i++) {
      dp[i] = new ArrayList<>();
    }
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++) {
      List<Integer> inner = new ArrayList<>();
      for(int j = 0; j < i; j++) {
        if(nums[i] % nums[j] == 0 && dp[j].size() > inner.size()) {
          inner = dp[j];
        }  
      }
      dp[i].addAll(inner);
      dp[i].add(nums[i]);
    }

    List<Integer> ans = new ArrayList<>();
    for(int i = 0; i < dp.length; i++) {
      if(ans.size() < dp[i].size()) {
        ans = dp[i];
      }
    }
    return ans;
  }
}
