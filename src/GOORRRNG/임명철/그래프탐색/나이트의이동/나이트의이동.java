import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int start_r = Integer.parseInt(st.nextToken());
            int start_c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_r = Integer.parseInt(st.nextToken());
            int end_c = Integer.parseInt(st.nextToken());
            bfs(n, new Node(start_r, start_c, 0), new int[] {end_r, end_c});
        }
    }
    public static void bfs(int n, Node start, int[] end){
        boolean[][] visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Node tmp = q.poll();
            if (tmp.r == end[0] && tmp.c == end[1]){
                System.out.println(tmp.cnt);
                return;
            }
            for (int i = 0; i < 8; i++){
                int newR = tmp.r + dr[i];
                int newC = tmp.c + dc[i];
                if (0 <= newR && newR < n && 0 <= newC && newC < n && !visited[newR][newC]){
                    q.add(new Node(newR, newC, tmp.cnt + 1));
                    visited[newR][newC] = true;
                }
            }
        }
    }
    public static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}