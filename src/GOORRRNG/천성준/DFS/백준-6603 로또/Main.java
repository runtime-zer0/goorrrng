
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static boolean[] visit;
	static int[] S;

	static ArrayList<String> answer = new ArrayList<>();

	public static void DFS(int start, int depth) {
		if (depth == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < S.length; i++) {
				if (visit[i]) {
					sb.append(S[i]);
					sb.append(" ");
				}
			}
			answer.add(sb.toString());
			return;
		}
		for (int i = start; i < visit.length; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			DFS(i + 1, depth + 1);
			visit[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String st[] = br.readLine().split(" ");
			if (st[0].equals("0"))
				break;
			int k = Integer.parseInt(st[0]);
			S = new int[k];
			visit = new boolean[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st[i + 1]);
			}
			DFS(0, 0);
			answer.add("");
		}
		for (String s : answer) {
			System.out.println(s);
		}

	}
}
