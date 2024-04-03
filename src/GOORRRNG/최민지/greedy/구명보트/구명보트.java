import java.util.*;

class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        // 무게 순 정렬
        Arrays.sort(people);

        int min_index = 0; // 제일 가벼운 사람
        int max_index = people.length - 1; // 제일 무거운 사람


        // 제일 무거운 사람 + 제일 가벼운 사람이 limit보다 작거나 같으면 둘을 태운다.
        // limit 보다 크면 제일 무거운 사람만 태운다. 
        while(min_index <= max_index){
            if(people[min_index] + people[max_index] <= limit){
                answer++;
                min_index++;
                max_index--;
            } else{
                answer++;
                max_index--;
            }
        }

        return answer;
    }
}
