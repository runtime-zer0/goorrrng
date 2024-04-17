import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int m, n;

	static String s1,s2;
	static int[][] dp;

	public static void solution(int s1end, int s2end) {
		for (int i = 1; i <= s1end; i++) {
			for (int j = 1; j <= s2end; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		m = s1.length();
		n = s2.length();
		dp = new int[m+1][n+1];
		solution(m,n);
		System.out.println(dp[m][n]);
		//System.out.println(solution(m-1,n-1));

	}
}
