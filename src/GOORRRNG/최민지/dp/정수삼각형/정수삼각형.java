class Solution {

  public int solution(int[][] triangle) {
      int answer = 0;

      int[][] dp = new int[triangle.length][triangle.length];
      // 삼각형을 좌측으로 정렬하여 계단 형태의 2차원 배열로 생각하고 푼다.     

      dp[0][0] = triangle[0][0];

      for(int i = 1;  i < triangle.length; i++){
          // 가장 좌측은 내려오는 경로가 하나
          dp[i][0] = dp[i-1][0] + triangle[i][0];
          for(int j = 1; j < i; j++){
              dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]; // 두 경로 중 큰 값에 해당 위치의 값을 더한다.
          }
          // 가장 우측도 내려오는 경로가 하나
          dp[i][i] = dp[i-1][i-1] + triangle[i][i];
      }

      // 삼각형의 높이 번째 원소중 최대값을 구하면 된다.
      for(int i = 0; i < triangle.length; i++){
          answer = Math.max(answer, dp[triangle.length - 1][i]);
      }

      return answer;
  }
}
