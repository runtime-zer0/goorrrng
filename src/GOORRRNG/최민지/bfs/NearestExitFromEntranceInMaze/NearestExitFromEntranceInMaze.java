import java.util.*;

class Solution {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        visited[entrance[0]][entrance[1]] = true;
        q.offer(new int[] {entrance[0], entrance[1], 0});

        while(!q.isEmpty()){
          int[] temp = q.poll();
          int x = temp[0];
          int y = temp[1];
          int dis = temp[2];

          if(x == 0 || y == 0 || x == m - 1 || y == n - 1){
            if(x != entrance[0] || y != entrance[1]) 
              return dis;
          }

          for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위, 방문 여부 확인
            if(nx >=0  && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.' && !visited[nx][ny]) {
              visited[nx][ny] = true; // 방문처리
              q.offer(new int[] {nx, ny, dis + 1});
            }
          }
        }

        return -1;
    }
}
