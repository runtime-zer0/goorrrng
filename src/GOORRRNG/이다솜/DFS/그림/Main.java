import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static List<Integer> cnt;

    public static void DFS (int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                cnt.set(cnt.size() - 1, cnt.get(cnt.size()-1) + 1);
                DFS(nx, ny);
            }
        }
    }



    public static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    cnt.add(1);
                    DFS(i ,j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cnt = new ArrayList<>();
        map = new int[n][m];

        boolean noDrowing = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    noDrowing = false;
                }
            }
        }

        if (noDrowing) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        solution();
        int max = Collections.max(cnt);

        System.out.println(cnt.size());
        System.out.println(max);

        br.close();
    }
}
