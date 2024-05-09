import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        double current = 0.0;
        for(int[] target : targets) {
            if(target[0] >= current) {
                answer++;
                current = target[1] - 0.5;
            }
        }
        return answer;
    }
}