import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Integer[][] timeTable = Arrays.stream(book_time)
            .map(array -> {
                Integer start = Integer.parseInt(array[0].substring(0, 2)) * 60 
                    + Integer.parseInt(array[0].substring(3, 5));
                 Integer end = Integer.parseInt(array[1].substring(0, 2)) * 60 
                    + Integer.parseInt(array[1].substring(3, 5));
                return new Integer[]{start, end};
            })
            .sorted((o1, o2) -> o1[0] - o2[0])
            .toArray(Integer[][]::new);
        List<Integer> rooms = new ArrayList<>();
        for(Integer[] time : timeTable) {
            Iterator<Integer> iter = rooms.iterator();
            while(iter.hasNext()) {
                if(iter.next() + 10 <= time[0])
                    iter.remove();
            }
            rooms.add(time[1]);
            answer = Math.max(answer, rooms.size());
        }
        return answer;
    }
}