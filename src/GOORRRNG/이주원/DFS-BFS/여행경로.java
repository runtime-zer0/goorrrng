import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        boolean[] visited = new boolean[tickets.length];
        
        List<String> answer = new ArrayList<>(tickets.length);
        answer.add("ICN");
        search(answer, "ICN", tickets, visited); 
        
        return answer.toArray(new String[0]);
    }
    
    void search(List<String> answer, String current, String[][] tickets, boolean[] visited) {
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                answer.add(tickets[i][1]);
                search(answer, tickets[i][1], tickets, visited);
                visited[i] = false;
                if(!(tickets.length + 1 == answer.size()))
                    answer.remove(answer.size()-1);
            }
        }
        
    }
}