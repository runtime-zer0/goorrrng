import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] dx={0,1};
	static int[] dy={1,0};

	static int n;
	static long[][] dp;
	static int[][] map;

	public static long dfs(int x, int y) {
		if(x==n-1&&y==n-1) return 1;
		if(dp[y][x]==-1) {
			dp[y][x]=0;
			for (int i = 0; i < 2; i++) {
				int nx=x+dx[i]*map[y][x];
				int ny=y+dy[i]*map[y][x];
				if(nx>=0&&ny>=0&&nx<n&&ny<n){
					dp[y][x]=dp[y][x]+dfs(nx,ny);
				}
			}
		}

		return dp[y][x];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long [n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		System.out.println(dfs(0,0));


	}
}
