package 수학.소용돌이_예쁘게_출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r1, r2, c1, c2, max = 0;
    static int[][] graph;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        graph = new int[r2-r1+1][c2-c1+1];

        fillNum();
        print();

        br.close();
    }

    static void fillNum() {
        int x = 0, y = 0, dir = 0;
        int num = 1, len = 1, cnt = 0;

        while(!isFin()) {
            if (r1 <= x && x <= r2 && c1 <= y && y <= c2) {
                graph[x - r1][y - c1] = num;
            }
            num++;
            cnt++;
            x = x + dx[dir];
            y = y + dy[dir];

            if (cnt == len) {
                cnt = 0;
                if (dir == 1 || dir == 3) len++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    static boolean isFin() {
        return graph[0][0] != 0 && graph[r2 - r1][0] != 0 && graph[0][c2 - c1] != 0 && graph[r2 - r1][c2 - c1] != 0;
    }

    static void print() {
        int maxLen = (int) Math.log10(max);
        int length;

        for (int i = 0; i <= r2- r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                length = maxLen - (int) Math.log10(graph[i][j]);
                for (int k = 0; k < length; k++) {
                    System.out.print(" ");
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
