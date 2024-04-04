
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<String> answer = new ArrayList<>();

	public static String solution(String s) {
		char[] arr = s.toCharArray();
		int lt = 0;
		int rt = arr.length - 1;
		String out = "YES";
		while (rt > 0) {
			int mid = (lt + rt) / 2;
			int size = rt - lt;

			for (int i = 0; i < mid; i++) {
				if (arr[i] == arr[size - i]) {
					out = "NO";
					break;
				}
			}
			rt = mid - 1;
		}
		return out;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			answer.add(solution(s));

		}
		for (String s : answer) {
			System.out.println(s);
		}
	}
}
