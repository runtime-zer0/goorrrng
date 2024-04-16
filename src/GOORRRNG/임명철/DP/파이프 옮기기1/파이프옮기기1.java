import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(1, 2, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // x는 세로, y는 가로
    // direction이 0일 때는 파이프가 가로 방향, 1일 때는 세로 방향, 2일 때는 대각선 방향.
    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) { // 종료 조건
            ans++;
            return;
        }

        switch (direction) {
            case 0: // 파이프가 가로 방향일 경우, 갈 수 있는 경우는 동쪽과 대각선임.
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }
                break;
            case 1: // 파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선임.
                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }

                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
        }

        // 파이프가 어떤 방향이든지, 대각선은 검사해서 가장 아래로 뺐음.
        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }

}
