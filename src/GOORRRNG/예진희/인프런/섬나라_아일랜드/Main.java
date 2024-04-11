package GOORRRNG.예진희.인프런.섬나라_아일랜드;

import java.util.*;

class Main {
    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상하좌우 대각선
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; // 상하좌우 대각선

    // 섬의 개수를 찾는 재귀 함수
    public void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 8; i++) { // 모든 방향에 대해서
            int nx = x + dx[i]; // 다음 x 좌표 계산
            int ny = y + dy[i]; // 다음 y 좌표 계산
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) { // 범위 내에 있고, 아직 방문하지 않은 육지인 경우
                board[nx][ny] = 0; // 방문 표시
                DFS(nx, ny, board); // DFS 실행
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) { // 보드의 모든 칸에 대해서
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // 아직 방문하지 않은 육지인 경우
                    answer++; // 새로운 섬을 찾았으므로 섬의 개수 증가
                    board[i][j] = 0; // 방문 표시. 0이기 때문에 더 이상 탐색을 안 함
                    DFS(i, j, board); // DFS 수행하여 인접한 모든 육지를 방문 처리
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
