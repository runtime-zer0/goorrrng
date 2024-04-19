package 구현.사탕_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, result = Integer.MIN_VALUE;
    static char[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                change(i, j, i, j+1);
                result = Math.max(result, solution());
                change(i, j, i, j+1);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                change(i, j, i+1, j);
                result = Math.max(result, solution());
                change(i, j, i+1, j);
            }
        }

        System.out.println(result);
    }

    public static int solution() {
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            int value = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j-1] == board[i][j]) {
                    value++;
                } else {
                    cnt = Math.max(cnt, value);
                    value = 1;
                }
            }
            cnt = Math.max(cnt, value);
        }

        for (int j = 0; j < n; j++) {
            int value = 1;
            for (int i = 1; i < n; i++) {
                if (board[i-1][j] == board[i][j]) {
                    value++;
                } else {
                    cnt = Math.max(cnt, value);
                    value = 1;
                }
            }
            cnt = Math.max(cnt, value);
        }
        return cnt;
    }

    public static void change(int i, int j, int x, int y) {
        char tmp = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = tmp;
    }
}
