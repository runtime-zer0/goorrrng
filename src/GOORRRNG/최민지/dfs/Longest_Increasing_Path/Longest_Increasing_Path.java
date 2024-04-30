class Solution {

  private static int row;
  private static int col;
  private static int max;

  private static int[] dr = {-1, 1, 0, 0};
  private static int[] dc = {0, 0, -1, 1};

  public int longestIncreasingPath(int[][] matrix) {
      
      // edge case
      if(matrix == null || matrix.length == 0)  return 0;

      row = matrix.length;
      col = matrix[0].length;
      max = 0;

      // 메모이제이션 배열 생성
      // 각 칸에서의 가장 긴 증가하는 경로의 길이를 저장
      int[][] memo = new int[row][col];

      for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
          if(memo[i][j] == 0){
            max = Math.max(max, dfs(matrix, memo, i, j));
          }
        }
      }

      return max;
  }

  private static int dfs(int[][] matrix, int[][] memo, int r, int c){

      // 현재 위치에 메모이제이션된 값이 이미 존재하는지 확인
      if(memo[r][c] > 0){
        // 해당 값 반환
        return memo[r][c];
      }

      int answer = 1;

      // 상하좌우로 이동
      for(int i = 0; i < 4; i++){
        int nr = r + dr[i];
        int nc = c + dc[i];

        // 범위 확인
        if(nr < 0 || nc < 0 || nr >= row || nc >= col){
          continue;
        }
        // 증가 여부 확인
        if(matrix[nr][nc] <= matrix[r][c]){
          continue;
        }

        // dfs로 다음 위치 계산
        // (nr, nc)로 이동했을 때의 길이를 더하기 위해 +1
        // 최댓값 갱신
        answer = Math.max(answer, dfs(matrix, memo, nr, nc) + 1);
      }

      // 현재 위치에서 가장 긴 증가하는 경로의 길이를 메모이제이션
      memo[r][c] = answer;
      return answer;
  }
}
