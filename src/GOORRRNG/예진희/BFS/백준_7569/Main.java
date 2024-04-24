package GOORRRNG.예진희.BFS.백준_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static int count = 0;
    //static boolean checked[];
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    Queue<Node> Q = new LinkedList<>();

    static class Node {
        int x, y, z, count;
        Node (int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }

    void BFS() {
        while(!Q.isEmpty()) {
            Node now = Q.poll();
            for (int i=0; i<6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
                if (map[nx][ny][nz] == 1) continue; // 익은 토마토면 패스
                if (map[nx][ny][nz] == -1) continue; // 빈칸이면 패스

                map[nx][ny][nz] = 1; // 토마토 익히기
                Q.add(new Node(nx, ny, nz, now.count + 1));
                count = now.count+1; // 재배일수 +1 증가
            }
        }
    }

    void Solve() {
        // 익은 토마토 찾아서 큐에 넣기
        for (int k=0; k<H; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j][k] == 1) {
                        Q.add(new Node(i, j, k, 0));
                    }
                }
            }
        }
        // 모든 토마토가 익었으면 0 출력 후 종료 (예외 처리함)
        if (Q.size() == N*M*H) {
            System.out.println(0);
            return;
        }
        // 토마토 익히기 시작
        BFS();
        // 안 익은 토마토 찾으면 -1 출력 후 종료 (예외 처리함)
        for (int k=0; k<H; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }

    void inputData() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());//열
        N = Integer.parseInt(st.nextToken());//행
        H = Integer.parseInt(st.nextToken());//높이
        map = new int[N][M][H];
        for (int k=0; k<H; k++) {
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.inputData();
        m.Solve();
    }
}