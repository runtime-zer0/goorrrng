package GOORRRNG.공태현.simulation.청소;

public class 청소 {
    static int dir = 1;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int[] solution(int[][] board, int k) {
        int n = board.length;
        int[] answer = new int[2];
        int x = 0, y = 0;
        while (k-- > 0) {
            int nx, ny;
            nx = x + dx[dir];
            ny = y + dy[dir];
            if (0 > nx || nx >= n || 0 > ny || ny >= n || board[nx][ny] == 1) {
                rotate();
                continue;
            }

            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    static void rotate() {
        dir = (dir + 1) % 4;
    }
}
