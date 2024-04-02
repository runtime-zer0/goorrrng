
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static int[] map;
	static int n;
	static int answer=0;

	public static void DFS(int depth) {
		if(depth==n) {
			answer++;
			return;
		}

		for(int i = 0;i<n;i++){
			map[depth]=i;
			if(isPossible(depth)){
				DFS(depth+1);
			}
		}

	}

	public static boolean isPossible(int col) {
		for (int i = 0; i < col; i++) {
			if (map[i] == map[col])
				return false;
			else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		DFS(0);
		System.out.println(answer);
	}
}
