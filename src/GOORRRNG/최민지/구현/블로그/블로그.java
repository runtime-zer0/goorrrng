import java.io.*;

public class Main {
	
	private static String[] inputs; // 입력값
	private static int N; // 블로그 시작 일수
	private static int X; // X일 동안 
	private static int[] arr;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		X = Integer.parseInt(inputs[1]);
		
		inputs = br.readLine().split(" ");
		
		br.close();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		// 슬라이딩 윈도우 기법 활용
		int sum = 0;
		for(int i = 0; i < X; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		int answer = 1;
		
		for(int i = 0; i < N-X; i++) {
			sum = sum - arr[i] + arr[i + X];
			
			if(sum == max) answer++;
			
			if(sum > max) {
				answer = 1;
				max = sum;
			}
			
		}
		
		// 최대 방문자 수가 0이면 SAD 출력
		if(max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(answer);
		}
		
	}
}
