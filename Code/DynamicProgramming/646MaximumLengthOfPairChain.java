// You are given n pairs of numbers. In every pair, the first 
// number is always smaller than the second number.

// Now, we define a pair (c, d) can follow another pair (a, b) if and 
// only if b < c. Chain of pairs can be formed in this fashion.

// Given a set of pairs, find the length longest chain which can be 
// formed. You needn't use up all the given pairs. You can select pairs 
// in any order.
import java.util.*;
class Solution {
  // DP bottom-up: keep track of longest chain pair including pair i in
  // dp[i]. We do this by finding the largest chain pair length dp[j]
  // and test is c > b, if so store dp[j] + 1 in dj[i]. We keep another
  // variable ans to keep track of the global maximal length.
  // Sort pairs by its second element so we can the b values in order
  public int findLongestChain(int[][] pairs) {
    if(pairs.length == 0) return 0;

    Arrays.sort(pairs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    int[] dp = new int[pairs.length];
    dp[0] = 1;
    int ans = 1;

    for(int i = 1; i < dp.length; i++) {
      int val = 0;
      int c = pairs[i][0];

      for(int j = 0; j < i; j++) {
        int b = pairs[j][1];

        if(c > b) {
          val = Math.max(val, dp[j]);
        }
      }

      dp[i] = val + 1;
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }
}
