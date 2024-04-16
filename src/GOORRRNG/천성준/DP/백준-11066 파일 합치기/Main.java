import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] files, sum;
	static int[][] dp;

	public static int solution(int start, int end) {
		if (start == end)
			return 0;
		if (dp[start][end] != Integer.MAX_VALUE)
			return dp[start][end];
		for (int i = start; i < end; i++) {
			int tmp;
			if (start == 0) {
				tmp = 0;
			} else
				tmp = sum[start - 1];
			int cost = solution(start, i) + solution(i + 1, end) + sum[end] - tmp;
			dp[start][end] = Math.min(cost, dp[start][end]);
		}
		return dp[start][end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			files = new int[n];
			sum = new int[n + 1];
			dp = new int[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; st.hasMoreTokens(); i++) {
				files[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				if (i == 0) {
					sum[i] = files[i];
				} else {
					sum[i] = sum[i - 1] + files[i];
				}
			}
			System.out.println(solution(0, n - 1));
		}

	}
}
