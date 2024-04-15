import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        
        String answer = Arrays.stream(numbers)
		.mapToObj(String::valueOf)
		.sorted((o1, o2) -> (o2+o1).compareTo(o1+o2))
		.collect(Collectors.joining());
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}