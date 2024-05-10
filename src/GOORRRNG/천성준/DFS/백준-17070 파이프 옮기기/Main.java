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
	static int n;
	static int[][] map;

	static int answer=0;

	static int[] dx = {1, 1, 0};
	static int[] dy = {0, 1, 1};

	// 오른쪽,대각선,아래 -> 0,1,2
	static class Point {
		int x;
		int y;
		int direction;

		public Point(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	public static void DFS(Point point){
		if(point.x==n-1&&point.y==n-1){
			answer++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(isPossible(point,i)){
				int nx=point.x+dx[i];
				int ny=point.y+dy[i];
				DFS(new Point(nx,ny,i));
			}
		}
	}

	public static boolean isPossible(Point point, int cmd) {
		if (point.direction == 0) {
			if (cmd == 0) {
				return isPossibleRight(point);
			} else if (cmd == 1) {
				return isPossibleCross(point);
			} else
				return false;
		} else if (point.direction == 1) {
			if (cmd == 0) {
				return isPossibleRight(point);
			} else if (cmd == 1) {
				return isPossibleCross(point);
			} else if (cmd == 2) {
				return isPossibleDown(point);
			} else
				return false;
		} else if (point.direction == 2) {
			if (cmd == 1) {
				return isPossibleCross(point);
			} else if (cmd == 2) {
				return isPossibleDown(point);
			} else
				return false;
		}
		return false;
	}

	public static boolean isPossibleRight(Point point){
		int nx = point.x + dx[0];
		int ny = point.y + dy[0];
		if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 0)
			return true;
		else
			return false;
	}
	public static boolean isPossibleDown(Point point){
		int nx = point.x + dx[2];
		int ny = point.y + dy[2];
		if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 0)
			return true;
		else
			return false;
	}
	public static boolean isPossibleCross(Point point){
		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			int nx = point.x + dx[i];
			int ny = point.y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 0)
				continue;
			else
				flag = false;
		}
		return flag;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		Point start = new Point(1,0,0);
		DFS(start);
		System.out.println(answer);
	}
}
