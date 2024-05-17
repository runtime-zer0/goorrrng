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
	static int n, m, k;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static char[][] map;

	static int[][] visit;

	static Point start, end;

	static class Point {
		int x;
		int y;
		int cnt;

		Point(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}
	}

	public static int BFS() {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(start);
		visit[start.x][start.y] = start.cnt;
		int time = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {
				Point currentPoint = Q.poll();
				//System.out.println("방금 큐에서 꺼낸 좌표 " + currentPoint.x + " " + currentPoint.y);
				if (currentPoint.x == end.x && currentPoint.y == end.y) {
					return currentPoint.cnt;
				}
				for (int j = 0; j < 4; j++) {
					int nx = currentPoint.x;
					int ny = currentPoint.y;
					for (int l = 0; l < k; l++) {
						nx += dx[j];
						ny += dy[j];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#')
							break;
						if (visit[nx][ny] < currentPoint.cnt + 1) break;
						if(visit[nx][ny]==Integer.MAX_VALUE){
							visit[nx][ny] = currentPoint.cnt+1;
							Q.offer(new Point(nx,ny, currentPoint.cnt+1));
						}
					}
				}
			}
		}
		return -1;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		int x2 = Integer.parseInt(st.nextToken()) - 1;
		int y2 = Integer.parseInt(st.nextToken()) - 1;
		start = new Point(x, y,0);
		end = new Point(x2, y2,0);
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(BFS());
		// for (int i = 0; i < n; i++) {
		// 	for (int j = 0; j < m; j++) {
		// 		System.out.print(visit[i][j]+" ");
		// 	}
		// 	System.out.println();
		// }
	}
}
