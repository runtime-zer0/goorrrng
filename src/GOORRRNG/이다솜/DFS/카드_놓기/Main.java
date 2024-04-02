package 카드_놓기;

import java.io.*;
import java.util.HashSet;


public class Main {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static HashSet<String> remove = new HashSet<>();

    public static void DFS (String str, int depth) {
        if (depth == k) {
            remove.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(str + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS("", 0);

        bw.write(String.valueOf(remove.size()));

        br.close();
        bw.flush();
        bw.close();
    }
}
