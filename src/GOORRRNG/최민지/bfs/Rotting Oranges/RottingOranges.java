import java.util.*;

class Solution {

  private final static int[] dx = {-1, 1, 0, 0};
  private final static int[] dy = {0, 0, -1, 1};

  private static int level;

  public int orangesRotting(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      Queue<int[]> q = new LinkedList<>(); // 위치 저장
      int fresh = 0; // 신선한 과일 개수

      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          int curr = grid[i][j];
          switch (curr){
            case 1 : fresh++; break; // 신선한 과일이면 
            case 2 : q.offer(new int[] {i, j}); break; // 썩은 과일이면 
          }
        }
      }

      if(fresh == 0) return 0; // edge case

      level = 0; // root
      // bfs
      while(!q.isEmpty()){
        int size = q.size();

        // 단계별로 큐를 확인해야 함.
        for(int i = 0; i < size; i++){
          int[] temp = q.poll();
          int x = temp[0];
          int y = temp[1];


          for(int j = 0; j < 4; j++){
            int nx = x + dx[j];
            int ny = y + dy[j];

            // 범위, 신선한 과일인지 확인
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) continue;
            else{
              grid[nx][ny] = 2;
              fresh--;
              q.offer(new int[] {nx, ny});
            }
          }
        }
        level++;
      }

      return fresh > 0 ? -1 : level - 1;
  }
}
