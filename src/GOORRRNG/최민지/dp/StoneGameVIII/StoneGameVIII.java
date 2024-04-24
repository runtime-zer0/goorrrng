class Solution {
  public int stoneGameVIII(int[] stones) {
      // Alice는 점수차이를 최대화
      // Bob은 점수차이 최소화

      // 둘 다 최적의 방법으로 게임을 한다면 게임을 먼저 하는 Alice가 최대 점수 차이를 얻으려고 할 것.

      // dp 배열 생성 : 각 위치까지의 돌의 합을 계산
      int[] dp = new int[stones.length-1];
      dp[0] = stones[0] + stones[1];

      // dp[i] = stones[0] ~ stones[i+1]까지의 합 
      for(int i = 1; i < dp.length; i++){
        dp[i] = dp[i-1] + stones[i+1];
      }

      int max = dp[dp.length-1];
      // 뒤에서 부터 앞으로 가면서 각 위치에서의 점수차이를 구하고 그 중에서 최대값을 찾아 max 에 저장
      for(int i = dp.length-2; i >= 0; i--){
        max = Math.max(max, dp[i] - max);
      }

      return max;

  }
}
