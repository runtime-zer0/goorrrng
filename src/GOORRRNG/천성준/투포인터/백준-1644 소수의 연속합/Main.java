import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static int[] getPrime(int n) {
		int[] prime = new int[n + 1];
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0) {
				primeList.add(i);
				for (int j = i; j <= n; j = j + i) {
					prime[j] = 1;
				}
			}
		}
		return primeList.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int solution(int n) {
		int answer = 0;
		int lt = 0;
		int rt = 0;
		int[] prime = getPrime(n);

		while (rt < prime.length) {
			int sum = 0;
			for (int i = lt; i <= rt; i++) {
				sum = sum + prime[i];
			}
			if (sum < n) {
				rt++;
			} else if (sum > n) {
				lt++;
			} else {
				answer++;
				rt++;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(solution(n));
	}
}
