import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class TopDown {
	static int[][] dp;

	public static int solution(int[][] triangle) {
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(answer, dp[triangle.length - 1][i]);
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//삼각형 크기 입력받기
		int[][] triangle = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(triangle));
	}
}
