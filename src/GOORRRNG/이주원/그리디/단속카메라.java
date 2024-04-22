import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int answer = 1;
        int position = routes[0][1];
        for(int[] car : routes) {
            if(car[0] > position) {
                answer++;
                position = car[1];
            }
        }
        return answer;
    }
}