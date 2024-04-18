package GOORRRNG.공태현.bfs.숲속의_기사;

import java.util.LinkedList;
import java.util.Queue;

public class 숲속의_기사 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int[][] board){
        int r = board.length;
        int c = board[0].length;

        int[][] distance = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if (board[i][j] == 2 || board[i][j] == 3) {
                    boolean[][] visited = new boolean[r][c];
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});

                    int level = 0;
                    while (!queue.isEmpty()) {
                        level++;

                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] cur = queue.poll();

                            for (int t = 0; t < 4; t++) {
                                int nx = cur[0] + dx[t];
                                int ny = cur[1] + dy[t];

                                if (0 <= nx && nx < r && 0 <= ny && ny < c && board[nx][ny] != 1) {
                                    if (!visited[nx][ny]) {
                                        visited[nx][ny] = true;
                                        distance[nx][ny] += level;
                                        queue.offer(new int[]{nx, ny});
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 4 && distance[i][j] != 0) {
                    answer = Math.min(answer, distance[i][j]);
                }
            }
        }

        return answer;
    }
}
