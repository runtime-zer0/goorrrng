import java.io.*;

public class Main {
	
	private static int N;
	private static int M;
	
	private static String inputs[];
	
	private static int[][] map;
	private static int[][] sum;
	
	public static void main(String args[]) throws Exception
	{
		// System.setIn(new FileInputStream("src/boj2169/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		sum = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			inputs = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		} // 맵 초기화
		
		sum[0][0] = map[0][0];
		for(int i = 1; i < M; i++) {
			sum[0][i] = sum[0][i-1] + map[0][i];
		} // 윗 방향으로는 움직일 수 없으므로 맨 윗줄을 이동하며 얻을 수 있는 최대값은 위와 같음. 
		
		// 각 위치까지의 최대 가치를 갱신한다.
		for(int i = 1; i < N; i++) {
			int[] left = new int[M]; // 왼쪽에서 오는 경우
			int[] right = new int[M]; // 오른쪽에서 오는 경우
			
			// 왼쪽에서 오는 경우
			left[0] = sum[i-1][0] + map[i][0]; // 맨 왼쪽 칸의 최댓값은 바로 윗칸 + 현재 칸
			for(int j = 1; j < M; j++) {
				// 바로 윗칸과 왼쪽칸 중 더 큰 값을 현재 칸의 값과 더한다.
				left[j] = Math.max(left[j-1], sum[i-1][j]) + map[i][j];
			}
			
			// 오른쪽에서 오는 경우
			right[M-1] = sum[i-1][M-1] + map[i][M-1]; // 맨 오른쪽 칸의 최댓값
			for(int j = M - 2; j >= 0 ; j--) {
				right[j] = Math.max(right[j+1], sum[i-1][j]) + map[i][j];
			}
			
			// 최댓값으로 갱신
			for(int j = 0; j < M; j++) {
				sum[i][j] = Math.max(left[j],right[j]);
			}
		}
		
		System.out.println(sum[N-1][M-1]);
	}
	
}
