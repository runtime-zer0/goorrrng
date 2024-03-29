package GOORRRNG.공태현.simulation.비밀번호;

import java.util.Arrays;

public class 비밀번호 {
    static int solution(int[] keypad, String password) {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int[][] padDistance = new int[10][10];
        int[][] pad = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }

        for (int i = 1; i <= 9; i++) {
            Arrays.fill(padDistance[i], 2);
            padDistance[i][i] = 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx, ny;
                for (int k = 0; k < 8; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (0 <= nx && nx < 3 && 0 <= ny && ny < 3) {
                        int from = pad[i][j];
                        int to = pad[nx][ny];
                        padDistance[from][to] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            int from = Integer.parseInt(String.valueOf(password.charAt(i)));
            int to = Integer.parseInt(String.valueOf(password.charAt(i + 1)));
            answer += padDistance[from][to];
        }

        return answer;
    }
}
