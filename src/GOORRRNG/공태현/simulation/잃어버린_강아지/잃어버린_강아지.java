package GOORRRNG.공태현.simulation.잃어버린_강아지;

public class 잃어버린_강아지 {

    static int solution(int[][] board) {
        int dir1 = 0, dir2 = 0;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
                if (board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        int time = 0;
        while (time < 10000) {
            time++;
            boolean isRotate1 = false, isRotate2 = false;
            int nx1 = x1 + dx[dir1];
            int ny1 = y1 + dy[dir1];
            int nx2 = x2 + dx[dir2];
            int ny2 = y2 + dy[dir2];

            if (0 > nx1 || nx1 >= 10 || 0 > ny1 || ny1 >= 10 || board[nx1][ny1] == 1) {
                dir1 = (dir1 + 1) % 4;
                isRotate1 = true;
            }
            if (0 > nx2 || nx2 >= 10 || 0 > ny2 || ny2 >= 10 || board[nx2][ny2] == 1) {
                dir2 = (dir2 + 1) % 4;
                isRotate2 = true;
            }
            if (!isRotate1) {
                x1 = nx1;
                y1 = ny1;
            }
            if (!isRotate2) {
                x2 = nx2;
                y2 = ny2;
            }
            if (x1 == x2 && y1 == y2) {
                return time;
            }
        }


        return 0;
    }

}
