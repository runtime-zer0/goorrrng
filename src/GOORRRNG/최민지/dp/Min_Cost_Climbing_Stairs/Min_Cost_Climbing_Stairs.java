class Solution {
  public int minCostClimbingStairs(int[] cost) {

      int[] dp = new int[cost.length+1];

      // dp[i] = i번째까지 왔을 때 최소 비용
      dp[0] = 0;
      dp[1] = 0;
      for(int i = 2; i < cost.length+1; i++){
        dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
      }

      int answer = dp[cost.length];

      return answer;

  }
}
