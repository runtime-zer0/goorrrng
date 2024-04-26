package GOORRRNG.공태현.graph.공_굴리기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 공_굴리기 {

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

    public static int solution(int[][] board, int[] s, int[] e){
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        pq.add(new Edge(s[0], s[1], 0));
        cost[s[0]][s[1]] = 0;

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.weight > cost[cur.x][cur.y]) {
                continue;
            }
            for(int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}){
                int nx = cur.x;
                int ny = cur.y;
                int len = cur.weight;

                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += cur.x;
                    ny += cur.y;
                    len++;
                }
                nx -= dir[0];
                ny -= dir[1];
                len --;

                if(cost[nx][ny] > len){
                    cost[nx][ny] = len;
                    pq.add(new Edge(nx, ny, len));
                }
            }
        }
        if(cost[e[0]][e[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return cost[e[0]][e[1]];
        }
    }
}
