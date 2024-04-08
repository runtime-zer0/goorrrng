import java.io.*;
import java.util.*;

class Solution
{
	private static int[][] arr;

	private final static int[] dx = {0, 0, -1, 1};
	private final static int[] dy = {1, -1, 0, 0};

	private static Set<String> set;

	public static void main(String args[]) throws Exception
	{

		// System.setIn(new FileInputStream("src/swea2819/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int[4][4];
			StringTokenizer st;
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			set = new HashSet<>();

			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(i, j, 0, ""+arr[i][j]);
				}
			}

			System.out.println("#" + test_case + " " + set.size());
		}
	}

	private static void dfs(int startRow, int startCol, int depth, String current) {
		if(depth == 6) { // 종료조건
			// 해시에 저장
			set.add(current);
			return ;
		}

		for(int i = 0; i < 4; i++) {
			int nx = startRow + dx[i];
			int ny = startCol + dy[i];

			// 범위 확인
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				dfs(nx, ny, depth + 1, current+arr[nx][ny]);
			}
		}
	}
}
