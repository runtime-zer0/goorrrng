package GOORRRNG.예진희.트리.백준_9372;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] plane;
    static boolean[] visit;
    static int N, M, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;

            plane = new int[N + 1][N + 1];
            visit = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                plane[u][v] = 1;
                plane[v][u] = 1;
            }
            bfs();
            bw.write(result - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            result++;
            int value = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (plane[value][i] != 0 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}