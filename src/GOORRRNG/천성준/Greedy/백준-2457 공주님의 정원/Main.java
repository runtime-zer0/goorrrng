import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Flower implements Comparable<Flower> {
		int startDay;
		int endDay;

		public Flower(int startDay, int endDay) {
			this.startDay = startDay;
			this.endDay = endDay;
		}


		@Override
		public int compareTo(Flower o1) {
			return o1.endDay-this.endDay;
		}
	}

	public static int solution(List<Flower> flowers){
		int startDay=301;
		int endDay=1201;
		int count=0;
		PriorityQueue<Flower> Q = new PriorityQueue<>();

		while(startDay<endDay){
			for(Flower f:flowers){
				if(f.startDay<=startDay&&f.endDay>startDay){
					Q.offer(f);
				}
			}
			if(Q.isEmpty()){
				return 0;
			}
			else{
				Flower choiceFlower = Q.poll();
				count++;
				startDay=choiceFlower.endDay;
				flowers.remove(choiceFlower);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Flower> flowers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startDay = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			flowers.add(new Flower(startDay,endDay));
		}
		System.out.println(solution(flowers));


	}
}
