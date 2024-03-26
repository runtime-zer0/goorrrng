import java.io.*;
import java.util.*;

public class HouseNumbering {
    static int answer, n;
    static List<Integer> cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] ch;

    public void DFS (int x, int y, int[][] map) {
        ch[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (map[nx][ny] == 1 && !ch[nx][ny]) {
                answer++;
                DFS(nx, ny, map);
            }
        }
    }

    public void solution (int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !ch[i][j]) {
                    DFS(i, j, map);
                    cnt.add(answer);
                    answer = 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        HouseNumbering T = new HouseNumbering();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cnt = new ArrayList<>();
        map = new int[n][n];
        ch = new boolean[n][n];
        answer = 1;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        T.solution(map);
        cnt.sort(Comparator.naturalOrder());

        System.out.println(cnt.size());
        for (int x : cnt) {
            System.out.println(x);
        }

        br.close();
    }
}