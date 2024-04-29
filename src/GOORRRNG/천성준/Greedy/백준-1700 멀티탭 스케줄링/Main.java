import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static int scheduleCheck(int[] schedule, int index, int appliance) {
		int count = 0;
		for (int i = index + 1; i < schedule.length; i++) {
			if (schedule[i] == appliance) {
				count = schedule.length-i;
				return count;
			}
		}
		return count;
	}

	public static int solution(int[] schedule, int n) {
		int count = 0;
		HashSet<Integer> multiTap = new HashSet<>();
		for (int i = 0; i < schedule.length; i++) {
			if (multiTap.contains(schedule[i])) {
				continue;
			} else {
				if (n > 0) {
					multiTap.add(schedule[i]);
					n--;
				} else {
					int[] min = new int[2];
					Arrays.fill(min, Integer.MAX_VALUE);
					for (int appliance : multiTap) {
						if (min[0] > scheduleCheck(schedule, i, appliance)) {
							min[0] = scheduleCheck(schedule, i, appliance);
							min[1] = appliance;
						}
					}
					multiTap.remove(min[1]);
					count++;
					multiTap.add(schedule[i]);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] schedule = new int[k];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; st.hasMoreTokens(); i++) {
			schedule[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(schedule, n));

	}
}
