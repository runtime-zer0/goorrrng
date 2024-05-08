import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] dis;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static HashSet<Character> set = new HashSet<>();

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int getMax(){
		int max=0;
		for (int i = 0; i <R; i++) {
			for (int j = 0; j < C; j++) {
				max=Math.max(max,dis[i][j]);
			}
		}
		return max;
	}

	public static void DFS(int depth, Point point) {
		dis[point.y][point.x] = Math.max(depth,dis[point.y][point.x]);
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + point.x;
			int ny = dy[i] + point.y;
			if (nx < 0 || ny < 0 || nx >= C || ny >= R)
				continue;
			if (set.contains(map[ny][nx]))
				continue;
			set.add(map[ny][nx]);
			DFS(depth + 1, new Point(nx, ny));
			set.remove(map[ny][nx]);
		}
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		dis = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			int j = 0;
			for (char c : s.toCharArray()) {
				map[i][j] = c;
				j++;
			}
		}
		set.add(map[0][0]);
	}

	public static void main(String[] args) throws IOException {
		init();
		DFS(1, new Point(0, 0));
		System.out.println(getMax());
	}
}
