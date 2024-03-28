package GOORRRNG.예진희.BFS.백준_2606;

import java.util.*;
public class Main {
    public static int[][] node;
    public static boolean[] visited;
    public static int M;
    public static int N;
    public static int result = 0;

    public static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.offer(start);

        while (!que.isEmpty()) {
            int temp = que.poll();

            // 현재 노드와 연결된 노드들을 탐색
            for (int i = 1; i <= M; i++) {
                // 연결되어 있고 아직 방문하지 않은 노드라면
                if (node[temp][i] == 1 && !visited[i]) {
                    // 큐에 추가 후 방문 표시
                    que.offer(i);
                    visited[i] = true;
                    // 값 증가
                    result++;
                }
            }
        }
        // 바이러스에 걸린 컴퓨터의 수 반환
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in);

        M = kb.nextInt();
        N = kb.nextInt();

        node = new int[M + 1][M + 1];
        visited = new boolean[M + 1];

        for (int i = 0; i < N; i++) {
            int m = kb.nextInt();
            int n = kb.nextInt();
            node[m][n] = node[n][m] = 1;
        }
        System.out.println(bfs(1));
    }
}