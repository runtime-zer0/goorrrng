package GOORRRNG.공태현.graph.교육_과정;

import java.util.*;

public class 교육_과정 {
    public static String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) {
            node.put(subjects[i], i);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];
        for(String x : course){
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a);
            degree[a]++;
        }

        List<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){
                degree[x]--;
                if(degree[x] == 0){
                    queue.offer(x);
                }
            }
        }

        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            answer[i] = subjects[order.get(i)];
        }
        return answer;
    }
}
