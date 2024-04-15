import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static int[][] dp;
	
	public static int solution(int start,int end){
		if(start==end) return 0;
		if(dp[start][end]!=Integer.MAX_VALUE) return dp[start][end];

		for (int i = start; i < end ; i++) {
			int a = solution(start,i)+solution(i+1,end)+matrix[start][0]*matrix[i][1]*matrix[end][1];
			dp[start][end] = Math.min(dp[start][end],a);
		}
		return dp[start][end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][2];
		dp = new int[n][n];


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i],Integer.MAX_VALUE);
		}

		System.out.println(solution(0,n-1));

		

	}
}
