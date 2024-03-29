import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] graph;
    static boolean[][] visited;

    public static void dfs (int i, int j, boolean row) {
        visited[i][j] = true;
        if (row) {
            j++;
            if (j < m && graph[i][j] == '-') dfs(i, j, true);
        } else {
            i++;
            if (i < n && graph[i][j] == '|') dfs(i, j, false);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (graph[i][j] == '-') dfs(i, j, true);
                    else dfs(i, j, false);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}