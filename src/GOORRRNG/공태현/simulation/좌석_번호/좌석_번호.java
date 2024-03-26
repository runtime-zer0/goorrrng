package GOORRRNG.공태현.simulation.좌석_번호;

public class 좌석_번호 {

    static int dir = 1;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int[] solution(int c, int r, int k) {

        if (c * r < k) {
            return new int[]{0, 0};
        }

        // 행이 c 컬럼이 r
        boolean[][] board = new boolean[c][r];

        int x = 0, y = 0;
        board[x][y] = true;
        int cnt = 1;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0 > nx || nx >= c || 0 > ny || ny >= r || board[nx][ny]) {
                rotate();
                continue;
            }
            board[nx][ny] = true;
            x = nx;
            y = ny;
            cnt++;
            if (cnt == k) {
                break;
            }

        }

        return new int[]{x+1, y+1};
    }

    static void rotate() {
        dir = (dir + 1) % 4;
    }
}
