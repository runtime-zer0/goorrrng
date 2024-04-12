import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n + 1];
		int[] price = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			int t=time[i];
			int p=price[i];
			if(i+t-1<=n){
				dp[i+t-1]=Math.max(dp[i+t-1],p+dp[i-1]);
			}

			dp[i]=Math.max(dp[i],dp[i-1]);
		}
		System.out.println(dp[n]);
	}
}
