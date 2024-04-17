import java.io.*;
import java.util.*;

public class Main {

	private static int T; // 테스트 케이스 수
	private static int N; 

	private static List<String> answer; // 정답 저장 배열

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for(int test_case = 0; test_case < T; test_case++) {
			N = Integer.parseInt(br.readLine());

			answer = new ArrayList<>();
			dfs(1, 1, 0, 1, "1");

			Collections.sort(answer);

			int size = answer.size();

			for(int i = 0; i < size; i++) {
				System.out.println(answer.get(i));
			}
			System.out.println();
		}
	}

	private static void dfs(int depth, int num, int sum, int op, String now) {
		// 종료 조건
		if(depth == N) {
			sum += (num*op); 
			if(sum == 0) {
				answer.add(now);
			}
			return;
		}

		dfs(depth + 1, depth+1, sum+(num*op), 1, now+"+"+(depth+1)); // + 인 경우
		dfs(depth + 1, depth+1, sum+(num*op), -1, now+"-"+(depth+1)); // -인 경우
		dfs(depth + 1, num*10 + (depth+1), sum, op, now+" "+(depth+1)); // 공백인 경우
	}
}
