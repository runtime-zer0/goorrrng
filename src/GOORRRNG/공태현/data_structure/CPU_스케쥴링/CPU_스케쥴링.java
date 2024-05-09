package GOORRRNG.공태현.data_structure.CPU_스케쥴링;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU_스케쥴링 {
    public static int[] solution(int[][] tasks){
        int n = tasks.length;
        int[] answer = new int[n];

        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++){
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int firstTime = 0, idx = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) {
                firstTime = Math.max(firstTime, programs.peek()[0]);
            }

            while(!programs.isEmpty() && programs.peek()[0] <= firstTime){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }

            int[] ex = pq.poll();
            firstTime = firstTime + ex[0];
            answer[idx++] = ex[1];
        }

        return answer;
    }
}
