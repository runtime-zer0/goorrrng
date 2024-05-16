package GOORRRNG.공태현.data_structure.가장_많이_사용된_회의실;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class 가장_많이_사용된_회의실 {
    public static int solution(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];

        PriorityQueue<int[]> endTimes = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            rooms.add(i);
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for(int[] m : meetings){
            while(!endTimes.isEmpty() && endTimes.peek()[0] <= m[0]) rooms.add(endTimes.poll()[1]);
            if (!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                res[room]++;
                endTimes.add(new int[]{m[1], room});
            } else {
                int[] e = endTimes.poll();
                res[e[1]]++;
                endTimes.add(new int[]{e[0] + (m[1] - m[0]), e[1]});
            }
        }

        int maxIdx = 0;
        for(int i = 0; i < n; i++){
            if(res[i] > maxIdx){
                maxIdx = res[i];
                answer = i;
            }
        }

        return answer;
    }
}
