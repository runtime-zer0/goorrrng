import java.util.*;

class Solution {

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    // 좌표적인 특성 때문에 이어지면 안되는 부분이 이어지는 경우를 발견함.
    // 이에 따라 좌표를 2배로 확장함.
    private static int[][] map = new int[101][101]; 
    private static boolean[][] isVisited = new boolean[102][102];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int i = 0; i < rectangle.length; i++){
            int[] tmp = rectangle[i];
            for(int j = 0; j < tmp.length; j++){
                tmp[j] *= 2;
            }

            // 선은 1, 내부는 2로 채움
            for(int x = tmp[0]; x <= tmp[2]; x++){
                for(int y = tmp[1]; y <= tmp[3]; y++){
                    // 2가 아닌 경우에만 선을 긋도록 해서 겹치는 부분 처리
                    if((x == tmp[0] || x == tmp[2] || y == tmp[1] || y == tmp[3]) &&
                      map[x][y]!=2) map[x][y] = 1;
                    else map[x][y] = 2;
                }
            }
        }
        answer = bfs(characterX, characterY, itemX, itemY);
        return answer;
    }

    // 선 따라서 bfs로 거리 계산
    private int bfs(int cx, int cy, int ix, int iy){

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {cx, cy, 0});
        isVisited[cx][cy] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            // 종료
            if(tmp[0] == ix && tmp[1] == iy)    return tmp[2]/2;

            for(int i = 0; i < 4; i++){
                int nr = tmp[0] + dr[i];
                int nc = tmp[1] + dc[i];

                // 범위 확인
                if(nr < 0 || nc < 0 || nr >= 101 || nc >= 101) continue;

                // 선 인지, 방문했는 지 확인
                if(map[nr][nc] != 1 || isVisited[nr][nc]) continue;

                // 조건 만족하면 큐에 넣음
                q.add(new int[] {nr, nc, tmp[2]+1});
                isVisited[nr][nc] = true;
            }
        }

        return 0;
    }
}
