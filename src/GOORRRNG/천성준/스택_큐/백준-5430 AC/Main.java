
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static String solution(String cmd, Deque<Integer> arr) {
		StringBuilder sb = new StringBuilder();
		boolean isRevers = false;
		for (char x : cmd.toCharArray()) {
			if (x == 'D') {
				if (arr.isEmpty()) {
					sb.append("error");
					return sb.toString();
				} else {
					if (isRevers)
						arr.pollLast();
					else
						arr.pollFirst();
				}
			} else if (x == 'R') {
				isRevers = !isRevers;
			}
		}
		sb.append("[");
		if (isRevers) {
			while (!arr.isEmpty()) {
				sb.append(arr.pollLast());
				if (!arr.isEmpty())
					sb.append(",");
			}
		} else {
			while (!arr.isEmpty()) {
				sb.append(arr.pollFirst());
				if (!arr.isEmpty())
					sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<String> answer = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			String cmd = br.readLine();
			int size = Integer.parseInt(br.readLine());
			Deque<Integer> Q = new ArrayDeque<>();
			String st = br.readLine();
			for (String s : st.substring(1, st.length() - 1).split(",")) {
				if (!s.isEmpty())
					Q.add(Integer.parseInt(s));
			}
			answer.add(solution(cmd, Q));
		}
		for (String s : answer) {
			System.out.println(s);
		}
	}
}
