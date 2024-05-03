class Solution {

  private int m;
  private int n;

  private static boolean[][] visited; // 방문 확인 배열

  private static int[] dr = {-1, 1, 0, 0};
  private static int[] dc = {0, 0, -1, 1}; // 방향 배열

  public boolean exist(char[][] board, String word) {

    // edge case
    if(board == null || board.length == 0 || board[0].length == 0)
      return false;

    m = board.length;
    n = board[0].length;

    visited = new boolean[m][n];

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        // 보드의 모든 위치에서 dfs를 호출하여 주어진 단어를 찾을 수 있는 지 여부 확인
        if(dfs(board, i, j, 0, word)){
          return true;
        }
      }
    }

    return false;

  }

  private boolean dfs(char[][] board, int r , int c, int depth, String word){

    if(depth == word.length()){
      return true;
    } // 종료 조건

    // 범위 확인
    if(r < 0 || r >= m || c < 0 || c >= n)  return false;
    // 이미 방문한 위치인지 확인
    if(visited[r][c]) return false;
    // 보드에 있는 문자가 해당 문자와 일치하는지 확인
    if(board[r][c] != word.charAt(depth)) return false;

    // 방문처리
    visited[r][c] = true;

    // 상하좌우 이동
    for(int i = 0; i < 4; i++){
      int nr = r + dr[i];
      int nc = c + dc[i];
      if(dfs(board, nr, nc, depth+1, word)){
        return true;
      }
    }

    visited[r][c] = false; // 백트래킹

    return false;
  }
}
