import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int answer = 0;
	static int[] chess;
	static int n;
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			answer = 0;
			chess = new int[n];
			dfs(0);
			System.out.println("#"+test_case+" "+answer);
		}
    
		sc.close();
	}
	
	private static void dfs(int depth) {
		if(depth == n) { // 종료조건
			answer++;
			return;
		}
		for(int i = 0; i < n ; i++) {
			chess[depth] = i;
			// 해당 열에서 i번째 행에 놓을 수 있는 지 검사
			if(checkPossible(depth)) {
				dfs(depth + 1);
			}
		}
	}
	
	private static boolean checkPossible(int depth) {
		for(int i = 0; i < depth; i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재하는 경우)
			// 대각선 상에 놓여있는 경우 확인 -> 행의 차와 열의 차가 같은 경우
			if(chess[depth] == chess[i] || depth - i == Math.abs(chess[depth] - chess[i])) {
				return false;
			}
		}
		return true;
	}
}
