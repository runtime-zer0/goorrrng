package GOORRRNG.예진희.DFS.백준_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char Grid[][];
    static boolean visit[][];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;
    static int notRGB = 0;
    static int RGB = 0;

    // 4방향 체크 dfs
    public static void dfs(int x, int y) {
        visit[x][y] = true;		// 현재 위치 방문체크
        char color = Grid[x][y];	// 현재 색 저장

        for(int i=0; i<4; i++) { // 상하좌우 체크
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N) {
                if(Grid[nx][ny] == color && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        Grid = new char[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String str = bf.readLine();
            for(int j=0; j<N; j++) {
                Grid[i][j] = str.charAt(j);
            }
        }

        // 적록색약이 아닌 사람이 봤을때 구역의 갯수 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 그리드 범위 내에 있고, 방문하지 않았으며, 현재 위치의 색과 동일한 색인 경우에만 다음 탐색을 진행
                if(!visit[i][j]) {
                    dfs(i, j);
                    notRGB ++;
                }
            }
        }

        // 적록색약인 사람의 경우 빨간색과 초록색의 차이를 느끼지 못 하기 때문에
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(Grid[i][j] == 'G')	// 초록을 빨강으로 변경
                    Grid[i][j] = 'R';
            }
        }

        visit = new boolean[N][N];	// 방문표시 초기화

        // 적록색약인 사람이 봤을때 구역의 갯수
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    RGB ++;
                }
            }
        }

        System.out.println(notRGB + " " + RGB);
        bf.close();
    }

}