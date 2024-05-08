package GOORRRNG.공태현.data_structure.피부과;

import java.util.LinkedList;
import java.util.Queue;

public class 피부과 {
    public static int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }

    public static int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(inList[0][1]);

        int firstTime = inList[0][0];
        int pos = 1;
        for(int time = firstTime; time <= 1200; time++){
            if(pos < n && time == inList[pos][0]){
                if(queue.isEmpty() && inList[pos][0] > firstTime) {
                    firstTime = inList[pos][0];
                }
                queue.offer(inList[pos][1]);
                pos++;
            }

            if(time == firstTime && !queue.isEmpty()){
                int idx = queue.poll();
                firstTime += laser[idx];
            }

            answer = Math.max(answer, queue.size());
        }

        return answer;
    }
}
