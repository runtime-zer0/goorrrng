package GOORRRNG.공태현.bfs.집을_짓자;

import java.util.LinkedList;
import java.util.Queue;

public class 집을_짓자 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        int[][] distance = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int emptyLand = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;

                    queue.offer(new int[]{i, j});
                    int level = 0;
                    while(!queue.isEmpty()){
                        level++;
                        int len = queue.size();

                        for(int r = 0; r < len; r++){
                            int[] cur = queue.poll();

                            for(int k = 0; k < 4; k++){
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];

                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){
                                    board[nx][ny]--;
                                    distance[nx][ny] += level;
                                    queue.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, distance[nx][ny]);
                                }
                            }
                        }
                    }

                    emptyLand--;
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
