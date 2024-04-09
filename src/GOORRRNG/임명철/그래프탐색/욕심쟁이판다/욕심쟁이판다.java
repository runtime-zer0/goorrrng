import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] dp;

    public static int DFS(int x, int y) {
        // dp에 저장된 값이 있을 경우 그 값을 반환.
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // 판다가 대나무 숲에서 최소한 1년은 살 수 있으므로
        // dp[x][y] = 1로 초기화 할 수 있음.
        dp[x][y] = 1;

        // 상하좌우 검사.
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위에서 벗어났을 경우 continue.
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            // 현재 대나무 숲보다 더 많은 양의 대나무가 있는 경우.
            if (map[x][y] < map[nx][ny]) {
                // 상하좌우 중에서 가장 오랫동안 생존할 수 있는 기간을 계산한다.
                dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
                DFS(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer = Math.max(answer,T.DFS(i,j));
            }
        }

        System.out.println(answer);
    }
}