import java.io.*;

public class Main {
	
	private static String input; // 입력 문자열 
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		br.close();
		
		int zeroCnt = 0;
		int oneCnt = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			sb.append(input.charAt(i));
			if(input.charAt(i) == '0')	zeroCnt++;
			if(input.charAt(i) == '1')	oneCnt++;
		}
		
		zeroCnt /= 2;
		oneCnt /= 2;
		
		// 재배열하는 것이 아니라 주어진 문자열 순서에서 0과 1을 제거하는 것임
		// 1은 앞에서부터, 0은 뒤에서부터 제거하는 것이 가능한 문자열 중 사전순으로 가장 빠른 것을 구할 수 있는 방법
		
		// 1 -> 2
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '1' && oneCnt != 0) {
				sb.setCharAt(i, '2');
				oneCnt--;
			};	
			if(oneCnt == 0) break;
		}
		
		// 0 -> 2
		for(int i = sb.length() -1; i >= 0; i--) {
			if(sb.charAt(i) == '0' && zeroCnt != 0) {
				sb.setCharAt(i,'2');
				zeroCnt--;
			}
			if(zeroCnt == 0) break;
		}
		
		String answer = "";
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == '1' || sb.charAt(i) == '0')
				answer += sb.charAt(i);
		}
		
		System.out.println(answer);
		
	}
}
