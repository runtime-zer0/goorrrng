import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] triangle;

	public static int DFS(int i,int j) {
		if(i==triangle.length-1){
			return triangle[i][j];
		}
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		dp[i][j] = triangle[i][j]+Math.max(DFS(i+1,j),DFS(i+1,j+1));
		return dp[i][j];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//삼각형 크기 입력받기
		triangle = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) { //삼각형 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(DFS(0,0));
	}
}
