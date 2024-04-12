import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int leftP = 0;
        for(int i = people.length-1; i >= leftP; i--) {
            if(people[i] + people[leftP] <= limit)
                leftP++;
            
            answer++;
        }
        
        return answer;
    }
}