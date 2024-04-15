package GOORRRNG.공태현.bfs.최단거리_통로_레벨탐색;

import java.util.LinkedList;
import java.util.Queue;

public class 최단거리_통로_레벨탐색 {

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue;
    static int[][] distance;
    public static int BFS(int[][] board) {
        queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        board[0][0] = 1;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (0 <= nx && nx < 7 && 0 <= ny && ny < 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        distance[nx][ny] = level;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        if (distance[6][6] == 0) {
            return -1;
        }

        return distance[6][6];
    }


    public static int solution(int[][] board) {
        distance = new int[7][7];

        return BFS(board);
    }
}
