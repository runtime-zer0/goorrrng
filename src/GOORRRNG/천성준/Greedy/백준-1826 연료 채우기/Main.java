import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Spot implements Comparable<Spot> {
	int location;
	int amount;

	public Spot(int location, int amount) {
		this.location = location;
		this.amount = amount;
	}

	@Override
	public int compareTo(Spot o) {
		return o.amount - this.amount;
	}
}

public class Main {
	static int currentAmount;
	static int totalLocation;

	public static int solution(List<Spot> oilList) {
		int count = 0;
		int currentLocation = 0;
		while (currentLocation < totalLocation) {
			if (currentLocation + currentAmount >= totalLocation) {
				return count;
			} else {
				PriorityQueue<Spot> Q = new PriorityQueue<>();
				for (Spot spot : oilList) {
					int length = spot.location - currentLocation;
					if (currentAmount >= length) {
						Q.add(spot);
					}
				}
				if (Q.isEmpty()) {
					return -1;
				} else {
					Spot tmp = Q.poll();
					oilList.remove(tmp);
					int lengthFromSpot = tmp.location - currentLocation;
					currentAmount -= lengthFromSpot;
					currentLocation += lengthFromSpot;
					currentAmount += tmp.amount;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Spot> oilList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int location = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());
			Spot spot = new Spot(location, amount);
			oilList.add(spot);
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		totalLocation = Integer.parseInt(st.nextToken());
		currentAmount = Integer.parseInt(st.nextToken());
		System.out.println(solution(oilList));

	}
}
