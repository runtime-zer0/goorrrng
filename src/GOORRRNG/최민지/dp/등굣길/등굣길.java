class Solution {
  public int solution(int m, int n, int[][] puddles) {
      int answer = 0;

      int[][] dp = new int[n][m]; // (x, y)
      dp[0][0] = 1; // 집 위치


      for(int[] puddle : puddles){
          int y = puddle[1] - 1;
          int x = puddle[0] - 1;

          dp[y][x] = -1;
      } // 웅덩이 위치에 -1 저장

      // 특정지역으로 위쪽에서 오는 겅우와 오른쪽에서 오는 경우로 2가지 밖에 없다. 
      // 현재 지역의 최소 경로 갯수 = 위쪽 지역의 최소 경로 갯수 + 왼쪽 지역의 최소 경로 갯수

      for(int y = 0; y < n; y++){
          for(int x = 0; x < m; x++){
              if(dp[y][x] == -1) {
                  dp[y][x] = 0;
                  continue; // 웅덩이 위치는 0으로 
              }

              if(y != 0) { // 0행이 아닌 칸
                  dp[y][x] += dp[y-1][x] % 1000000007;
              }

              if(x != 0) { // 0열이 아닌 칸
                  dp[y][x] += dp[y][x-1] % 1000000007;
              }
          }

      }

      answer = dp[n-1][m-1] % 1000000007;

      return answer;
  }
}
