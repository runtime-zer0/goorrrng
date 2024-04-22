import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static public long solution(long x, long y, long rc, long cross) {
		if (2 * rc <= cross) {
			return (x + y) * rc;
		} else {
			long sum = Math.min(x, y) * cross;
			long remainingDistance = Math.abs(x - y);
			if (rc <= cross) {
				return sum + remainingDistance * rc;
			} else {
				if (remainingDistance % 2 == 0) {
					return sum + remainingDistance * cross;
				} else {
					return sum + (remainingDistance - 1) * cross + rc;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long rc = Integer.parseInt(st.nextToken());
		long cross = Integer.parseInt(st.nextToken());
		System.out.println(solution(x, y, rc, cross));

	}
}
