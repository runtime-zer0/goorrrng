package GOORRRNG.공태현.graph.벽_허물기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 벽_허물기 {
    public static class Edge {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        cost[0][0] = 0;
        queue.add(new Edge(0, 0, 0));

        while(!queue.isEmpty()) {
            Edge cur = queue.poll();
            if(cur.weight > cost[cur.x][cur.y]) {
                continue;
            }
            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(board[nx][ny] == 0 && cost[nx][ny] > cur.weight) {
                    cost[nx][ny] = cur.weight;
                    queue.offer(new Edge(nx, ny, cur.weight));
                }
                else if(board[nx][ny] == 1 && cost[nx][ny] > cur.weight + 1){
                    cost[nx][ny] = cur.weight + 1;
                    queue.offer(new Edge(nx, ny, cur.weight + 1));
                }
            }
        }

        return cost[n - 1][m - 1];
    }
}
