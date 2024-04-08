
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n;

	public static void DFS(String result) {
		if (result.length() == n) {
			System.out.println(result);
			System.exit(0);
			return;
		} else {
			for (int i = 1; i <= 3; i++) {
				if (possible(result + i)) {
					DFS(result + i);
				}
			}
		}

	}

	public static boolean possible(String s) {
		int count = s.length() / 2;
		for (int i = 1; i <= count; i++) {
			if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		DFS("");

	}
}
