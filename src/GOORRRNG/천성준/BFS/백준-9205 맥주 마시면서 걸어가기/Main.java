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

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean bfs(Point start, Point end, List<Point> storeList) {
		Queue<Point> Q = new LinkedList<>();
		boolean[] visit = new boolean[storeList.size()];
		Q.offer(start);
		while (!Q.isEmpty()) {
			Point currentPoint = Q.poll();
			if (getDistance(currentPoint, end) <= 1000) {
				return true;
			}
			for (int i = 0; i < storeList.size(); i++) {
				if ((getDistance(currentPoint, storeList.get(i)) <= 1000)&&!visit[i]) {
					Q.offer(storeList.get(i));
					visit[i]=true;
				}
			}
		}
		return false;
	}

	public static int getDistance(Point a, Point b) {
		return Math.abs(b.x - a.x) + Math.abs(b.y - a.y);
	}

	public static String solution(Point start, Point end, List<Point> storeList) {
		if (bfs(start, end, storeList))
			return "happy";
		else
			return "sad";

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			List<Point> storeList = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				Point store = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				storeList.add(store);
			}
			st = new StringTokenizer(br.readLine(), " ");
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sb.append(solution(start,end,storeList)+"\n");
		}
		System.out.println(sb);
	}
}
