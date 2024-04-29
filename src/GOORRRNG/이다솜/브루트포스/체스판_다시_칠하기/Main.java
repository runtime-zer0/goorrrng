package 체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int curcnt = solution(i, j, board);
                if (cnt > curcnt) cnt = curcnt;
            }
        }

        System.out.println(cnt);

        br.close();
    }

    static int solution(int startRow, int startCol, String[] board) {
        String[] startBoard = {"WBWBWBWB", "BWBWBWBW"};
        int white = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (board[row].charAt(col) != startBoard[row%2].charAt(j)) white++;
            }
        }
        return Math.min(white, 64-white);
    }
}
