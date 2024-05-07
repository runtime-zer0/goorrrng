import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> heavy = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> light = new ArrayList<>();
	static boolean[] visit;

	public static int DFS(int ball, ArrayList<ArrayList<Integer>> cmd) {
		int sum=0;
		visit[ball]=true;
		for (int a : cmd.get(ball)) {
			if(visit[a]) continue;
			visit[a]=true;
			sum=1+DFS(a, cmd);
		}
		return sum;
	}

	public static int solution(int n) {
		int answer = 0;
		int half = n>>1;
		for (int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			int HCount=DFS(i,heavy);
			visit = new boolean[n+1];
			int LCount=DFS(i,light);
			if(HCount>=half||LCount>=half){
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++) {
			heavy.add(new ArrayList<>());
			light.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			heavy.get(b).add(a);
			light.get(a).add(b);
		}

		System.out.println(solution(n));
	}
}
