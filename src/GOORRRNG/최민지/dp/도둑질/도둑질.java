class Solution {
  public int solution(int[] money) {
      int answer = 0;

      // 집이 3개라면 한 집만 고를 수 있다. 가장 돈이 많은 집
      if(money.length == 3){
          int max = Integer.MIN_VALUE;
          for(int i = 0; i < 3; i++){
              max = Math.max(max, money[i]);
          }

          return max;
      }

      // dp[i] -> i 번째 집까지 방문했을 때 얻을 수 있는 최대 금액 저장

      // i번째 집을 턴다면 dp[i]에는 -> i-1을 털지 못하므로, i-2까지 방문했을 때의 가능한 최대 금액 + i번째 집을 턴 금액 
      // i번째 집을 털지 않는다면 dp[i]에는 -> i-1까지 방문했을 때의 가능한 최대 금액
      // 둘 중 더 큰 값을 저장한다. 



      // 첫 번째 집을 고르는 경우 -> 마지막 집을 고를 수 없음
      int[] dp = new int[money.length];
      dp[0] = money[0]; // 첫 번째 집
      dp[1] = money[0]; // 두 번째 집은 무조건 고를 수없으므로 첫 번째 집 값 저장

      // 마지막 앞 집까지
      for(int i = 2; i < money.length - 1; i++){
          dp[i] = Math.max(money[i] + dp[i-2], dp[i-1]);
      }
      // 마지막 집은 앞집의 최대값을 따른다.
      dp[money.length-1] = dp[money.length-2];
      answer = dp[money.length-1];



      // 첫 번쨰 집을 고르지 않는 경우 -> 마지막 집을 고를 수 있음
      dp = new int[money.length];
      dp[0] = 0;
      dp[1] = money[1]; // 두 번째 집을 고른다.

      for(int i = 2; i < money.length-1; i++){
          dp[i] = Math.max(money[i] + dp[i-2], dp[i-1]);
      }
      // 마지막 집은 두 칸 전의 집까지 방문했을 때의 가능한 최대값 + 마지막 집의 금액
      dp[money.length-1] = dp[money.length-3] + money[money.length-1];

      // 앞선 경우와 비교해 더 큰 값 반환
      answer = Math.max(answer, dp[money.length-1]);

      return answer;
  }
}
