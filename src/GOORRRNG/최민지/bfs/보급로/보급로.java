import java.io.*;
import java.util.*;

class Solution
{

	private static int n; // 지도 크기
	private static int[][] arr; // 지도 정보 저장 배열
	private static int[][] sum; // 최소 비용 저장 배열

	private final static int dx[] = {1, 0, -1, 0};
	private final static int dy[] = {0, -1, 0, 1};


	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	  int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			sum = new int[n][n];

			for(int i = 0; i < n; i++) {
				Arrays.fill(sum[i], Integer.MAX_VALUE);
			}

			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			} 

			sum[0][0] = 0;

			bfs();

			System.out.println("#" + test_case + " " + sum[n-1][n-1]);

		}

	}

	private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 0 }); // 현재 위치와 현재까지의 비용을 담음

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                // 범위 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)continue;

                int cost = temp[2] + arr[nx][ny]; // 비용 계산
                if (sum[nx][ny] > cost) { // 더 짧은 거리로 갱신 될 때만 큐에 넣음 
                    sum[nx][ny] = cost;
                    q.offer(new int[] { nx, ny, cost });
                }
            }
        }

    }
}
