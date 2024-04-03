import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, p1, p2, answer = -1;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void DFS (int a, int b) {
        visited[a] = true;
        if (a == p2) {
            answer = b;
            return;
        }

        for (int nv : graph.get(a)) {
            if (!visited[nv]) DFS(nv, b+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];
        DFS(p1, 0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
