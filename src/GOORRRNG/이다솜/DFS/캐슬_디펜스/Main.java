package 캐슬_디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, D;
    static int[][] board;
    static int[][] copyBoard;
    static int[] dx = {0, -1, 0}; // 궁수의 공격 가능한 위치 (좌, 상, 우)
    static int[] dy = {-1, 0, 1};
    static int maxDestroyed = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 3명을 배치하는 모든 경우의 수를 탐색
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {
                    maxDestroyed = Math.max(maxDestroyed, simulate(i, j, k));
                }
            }
        }

        System.out.println(maxDestroyed);

        br.close();
    }

    // 궁수의 위치에 따른 게임 시뮬레이션
    static int simulate(int a, int b, int c) {
        int destroyed = 0;
        copyBoard = new int[N][M];

        // 원래의 보드 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, M);
        }

        // 게임 진행
        while (true) {
            int cnt = 0;
            List<int[]> targets = new ArrayList<>();

            // 각 궁수별로 공격할 적 찾기
            for (int[] archer : new int[][]{{N, a}, {N, b}, {N, c}}) {
                int minDist = Integer.MAX_VALUE;
                int targetX = -1, targetY = -1;

                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        if (copyBoard[i][j] == 1) {
                            int dist = Math.abs(i - archer[0]) + Math.abs(j - archer[1]);
                            if (dist <= D && dist < minDist) {
                                minDist = dist;
                                targetX = i;
                                targetY = j;
                            } else if (dist <= D && dist == minDist && j < targetY) {
                                targetX = i;
                                targetY = j;
                            }
                        }
                    }
                }

                if (targetX != -1 && targetY != -1) {
                    targets.add(new int[]{targetX, targetY});
                }
            }

            // 공격받은 적 제거
            for (int[] target : targets) {
                if (copyBoard[target[0]][target[1]] == 1) {
                    copyBoard[target[0]][target[1]] = 0;
                    cnt++;
                }
            }

            destroyed += cnt;

            // 적 이동
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (copyBoard[i][j] == 1) {
                        copyBoard[i][j] = 0;
                        if (i + 1 < N) {
                            copyBoard[i + 1][j] = 1;
                        }
                    }
                }
            }

            // 게임 종료 조건
            boolean allDead = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyBoard[i][j] == 1) {
                        allDead = false;
                        break;
                    }
                }
                if (!allDead) break;
            }

            if (allDead) break;
        }

        return destroyed;
    }
}
