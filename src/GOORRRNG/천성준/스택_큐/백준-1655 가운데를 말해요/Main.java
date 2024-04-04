
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			if (maxHeap.size() == minHeap.size())
				maxHeap.offer(m);
			else
				minHeap.offer(m);
			if (maxHeap.peek() != null & minHeap.peek() != null) {
				if (maxHeap.peek() > minHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(minHeap.poll());
				}
			}


			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb.toString());
	}

}
