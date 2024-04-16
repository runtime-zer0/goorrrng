import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int max = Math.max(Math.max(Math.max(func(r1, c1), func(r1, c2)), func(r2, c1)), func(r2, c2));
		int place = (int) Math.log10(max) + 1;
		
		StringBuilder answer = new StringBuilder();
		
		for(int i = r1; i <= r2; i++) {
			for(int j = c1; j <= c2; j++) {
				answer.append(("%"+place+"d ").formatted(func(i, j)));
			}
			answer.append("\n");
		}
		
		System.out.println(answer);
		br.close();
	}
	
	private static int func(int r, int c) {
		
		int n = Math.max(Math.abs(r), Math.abs(c));
		int max = 4*n*n + 4*n + 1;
		int length = 2*n;
		
		if(r == n)
			return max-(n-c);
		if(c == -n)
			return max-length-(n-r);
		if(r == -n)
			return max-length*2-(n+c);
		
		return max-length*3-(n+r);
	}
	
}