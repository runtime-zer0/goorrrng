package GOORRRNG.공태현.data_structure.현관문_출입_순서;

import java.util.LinkedList;
import java.util.Queue;

public class 현관문_출입_순서 {

    public static int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();

        int n = arrival.length, prev = 1;
        int[] answer = new int[n];
        for(int t = 0, i = 0, cnt = 0; ; t++){
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }

            while(i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    enter.offer(i);
                } else {
                    exit.offer(i);
                }
                i++;
            }

            if(prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if(prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }

            cnt++;
            if (cnt == n) {
                break;
            }
        }

        return answer;
    }
}
