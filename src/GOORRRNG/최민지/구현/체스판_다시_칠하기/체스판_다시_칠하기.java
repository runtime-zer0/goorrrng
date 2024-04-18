import java.io.*;;

public class Main {

	private static String[] inputs;

	private static int N; // 세로 길이
	private static int M; // 가로 길이

	private static String[] map; // 체스판 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inputs = br.readLine().split(" ");

		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		map = new String[N];
		for(int i = 0; i < N; i ++) {
			map[i] = br.readLine();
		} // 체스판 초기화

		// 흰 색 먼저 시작하는 보드
		String[] Wmap = new String[8];
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0) Wmap[i] = "WBWBWBWB";
			else Wmap[i] = "BWBWBWBW";
		}

		// 검은 색 먼저 시작하는 보드
		String[] Bmap = new String[8];
		for(int i = 0; i < 8; i++) {
			if(i % 2 == 0)Bmap[i] = "BWBWBWBW";
			else Bmap[i] = "WBWBWBWB";
		}

		int min = Integer.MAX_VALUE;

		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				int Wcnt = 0;
				int Bcnt = 0;
				for(int k = 0; k < 8; k++) {
					for(int l = 0; l < 8; l++) {
						if(Wmap[k].charAt(l) != map[k+i].charAt(l+j)) Wcnt++;
						if(Bmap[k].charAt(l) != map[k+i].charAt(l+j)) Bcnt++;
					}
				}
				min = Math.min(min, Math.min(Wcnt, Bcnt));
			}
		}

		System.out.println(min);
	}
}
