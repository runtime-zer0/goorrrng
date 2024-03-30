import java.util.*;

class Solution {
    // bfs 이용 

    private static int n, m; // 맵의 행과 열의 크기 저장
    private static int answer = -1; // 답이 없으면 -1

    // 상하좌우 이동
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    // 방문 체크 배열
    private static boolean visited[][];

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        // (0, 0) 부터 출발
        answer = bfs(0, 0, maps);
        return answer;
    }

    private static int bfs(int x, int y, int[][] maps){
        // 큐 이용
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, y, 1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            // 큐에서 하나를 꺼내고 x, y값, count값 지정
            int temp[] = q.poll();
            x = temp[0];
            y = temp[1];
            int count = temp[2];

            // (n, m) 위치에 도달하면 종료
            if(x == n - 1&& y == m - 1){
                answer = count;
                break;
            }

            // 상하좌우 확인하면서 
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵의 범위를 벗어나는 지 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인지 확인
                if(maps[nx][ny] == 0) continue;
                // 방문하지 않은 배열이고, 길이라면 
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    // 방문처리
                    visited[nx][ny] = true;
                    // 해당 위치와 count+1 해서 큐에 넣는다. 
                    q.add(new int[] {nx, ny, count+1});
                }
            }
        }
        return answer;
    }
}
