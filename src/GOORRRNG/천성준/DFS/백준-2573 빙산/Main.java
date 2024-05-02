import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static class Ice {
		int x;
		int y;

		public Ice(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void melt() {
		Queue<Ice> Q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					Q.offer(new Ice(j, i));
					visit[i][j] = true;
				}
			}
		}
		while (!Q.isEmpty()) {
			Ice iceBlock = Q.poll();
			int meltIce = 0;
			for (int i = 0; i < 4; i++) {
				int nx = iceBlock.x + dx[i];
				int ny = iceBlock.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= m || ny >= n)
					continue;
				if (visit[ny][nx])
					continue;
				if (map[ny][nx] == 0)
					meltIce++;
			}
			if (map[iceBlock.y][iceBlock.x] - meltIce < 0) {
				map[iceBlock.y][iceBlock.x] = 0;
			} else
				map[iceBlock.y][iceBlock.x] = map[iceBlock.y][iceBlock.x] - meltIce;

		}
	}

	public static void dfs(boolean[][] visit, int x, int y) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;
			if (!visit[ny][nx] && map[ny][nx] != 0) {
				dfs(visit, nx, ny);
			}
		}
	}

	public static int countIce() {
		boolean[][] visit = new boolean[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j] && map[i][j] != 0) {
					dfs(visit, j, i);
					count++;
				}
			}

		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = countIce();
		int answer = 0;
		while (count<2){
			melt();
			answer++;
			count=countIce();
			if(count==0){
				answer=0;
				break;
			}

		}
		System.out.println(answer);
	}
}
