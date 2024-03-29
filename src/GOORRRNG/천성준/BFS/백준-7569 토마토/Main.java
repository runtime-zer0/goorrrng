
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int z;
	int y;
	int x;

	public Point(int z, int y, int x) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static Queue<Point> Q = new LinkedList<>();
	static int[][][] board, dir;
	static int n, m, h;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void BFS() {
		while (!Q.isEmpty()) {
			Point tmp = Q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int nz = tmp.z + dz[i];
				if (nx < 0 || nx >= m ||
					ny < 0 || ny >= n ||
					nz < 0 || nz >= h)
					continue;
				if (board[nz][ny][nx] == 0) {
					Q.offer(new Point(nz, ny, nx));
					board[nz][ny][nx] = 1;
					dir[nz][ny][nx] = dir[tmp.z][tmp.y][tmp.x] + 1;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		board = new int[h][n][m];
		dir = new int[h][n][m];
		boolean flag = true;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int k = 0;
				while (st.hasMoreTokens()) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 1)
						Q.offer(new Point(i, j, k));
					k++;
				}
			}
		}
		BFS();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (board[i][j][k] == 0)
						flag = false;
					max = Math.max(max, dir[i][j][k]);
				}
			}
		}
		if (flag)
			System.out.println(max);
		else
			System.out.println(-1);

	}
}
