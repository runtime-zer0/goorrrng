package GOORRRNG.예진희.큐.백준_1417;
import java.io.*;
import java.util.*;
public class Baek_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(kb.readLine());
        int dasom = Integer.parseInt(kb.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<N; i++) queue.offer(Integer.parseInt(kb.readLine()));

        int cnt = 0;
        while(!queue.isEmpty() && dasom <= queue.peek()){
            queue.offer(queue.poll()-1);
            dasom++;
            cnt++;
        }

        System.out.println(cnt);

    }
}
