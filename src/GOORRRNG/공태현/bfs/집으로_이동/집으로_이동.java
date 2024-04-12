package GOORRRNG.공태현.bfs.타일_점프.집으로_이동;

import java.util.LinkedList;
import java.util.Queue;

public class 집으로_이동 {

    public static class JumpInfo {
        int pos;
        String dir;

        public JumpInfo(int pos, String dir) {
            this.pos = pos;
            this.dir = dir;
        }
    }

    static boolean[][] visited;
    static Queue<JumpInfo> queue;
    static int a, b, home;
    static int pool;

    static int BFS(int[] pool, int a, int b, int home) {
        // 물웅덩이는 갈 수 없으므로 이미 방문했다고 체크
        for (int val : pool) {
            visited[0][val] = true;
            visited[1][val] = true;
        }

        queue = new LinkedList<>();
        // 시작점은 앞으로든, 뒤로든 갈 수 있다.
        queue.offer(new JumpInfo(0, "front"));

        // 시작 위치 방문 표시
        visited[0][0] = true;
        visited[1][0] = true;

        // 트리의 레벨이자 점프 횟수를 의미
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                JumpInfo cur = queue.poll();

                if (cur.pos == home) {
                    return level;
                }

                // 앞으로 점프는 어떤 경우에도 할 수 있다.
                int nx = cur.pos + a;
                if (0 <= nx && nx <= 10000 && !visited[0][nx]) {
                    visited[0][nx] = true;
                    queue.offer(new JumpInfo(nx, "front"));
                }

                // 뒤로 점프는 현재 탐생중인 위치를 앞으로 점프한 경우에서만 뒤로 점프가 가능하다.
                if (cur.dir.equals("front")) {
                    nx = cur.pos - b;

                    if (0 <= nx && nx <= 10000 && !visited[1][nx]) {
                        visited[1][nx] = true;
                        queue.offer(new JumpInfo(nx, "back"));
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public static int solution(int[] pool, int a, int b, int home) {
        // 각 위치마다 앞으로 점프했을때 도착하는 경우가 있고 뒤로 점프했을때 도착하는 경우가 있기 때문에
        // 따로 체크해줘야 한다.
        visited = new boolean[2][10001];

        return BFS(pool, a, b, home);
    }
}
