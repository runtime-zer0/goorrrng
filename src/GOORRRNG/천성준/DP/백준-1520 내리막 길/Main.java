import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] dp;
	static int[][] map;
	static int n, m;

	public static int DFS(int i, int j) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		if (dp[i][j] == -1) {
			dp[i][j] = 0;
			for (int k = 0; k < 4; k++) {
				int nx = j + dx[k];
				int ny = i + dy[k];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[i][j] > map[ny][nx]) {
					dp[i][j] = dp[i][j] + DFS(ny, nx);
				}
			}
		}
		return dp[i][j];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		map = new int[m][n];
		dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(DFS(0, 0));
	}
}
