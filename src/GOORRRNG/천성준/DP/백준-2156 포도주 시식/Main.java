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
	static int[] dp;
	static int[] arr;

	public static int recur(int a) {
		if(dp[a]==-1){
			dp[a]=Math.max(recur(a-2),recur(a-3)+arr[a-1])+arr[a];
		}
		return dp[a];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		arr= new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp,-1);
		dp[0]=0;
		dp[1]=arr[1];

		if(n>1){
			dp[2]=arr[1]+arr[2];
		}
		System.out.println(recur(n));



	}
}
