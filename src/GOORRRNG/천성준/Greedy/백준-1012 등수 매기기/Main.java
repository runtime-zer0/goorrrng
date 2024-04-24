import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static public long solution(long[] arr) {
		Arrays.sort(arr);
		long sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=Math.abs(arr[i]-(i+1));
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		System.out.println(solution(arr));

	}
}
