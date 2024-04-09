import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int count;
	static int[][] map = new int[9][9];

	static int[] answer;

	static ArrayList<Point> pointArr = new ArrayList<>();

	public static void DFS(int depth) {
		if (depth == count) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					sb.append(map[j][k]);
					sb.append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		for (int i = 1; i < 10; i++) {
			if (possible(pointArr.get(depth), i)) {
				Point tmp = pointArr.get(depth);
				map[tmp.y][tmp.x]=i;
				DFS(depth + 1);
				map[tmp.y][tmp.x]=0;
			}
		}

	}

	public static boolean possible(Point point, int n) {
		for (int i = 0; i < 9; i++) {
			if(map[point.y][i]==n)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if(map[i][point.x]==n)
				return false;
		}
		int startX = point.x/3*3;
		int startY = point.y/3*3;
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (map[j][i] == n)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					pointArr.add(new Point(i, j));
				j++;
			}
		}
		count = pointArr.size();
		answer = new int[count];
		DFS(0);

	}
}
