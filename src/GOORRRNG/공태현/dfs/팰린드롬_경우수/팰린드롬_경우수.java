package GOORRRNG.공태현.dfs.팰린드롬_경우수;

import java.util.*;

public class 팰린드롬_경우수 {

    static Map<String, Integer> map;
    static Deque<String> deque;
    static int len;
    static List<String> res;

    public static void DFS() {
        if (deque.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (String s : deque) {
                sb.append(s);
            }
            res.add(sb.toString());

        } else {
            for (String key : map.keySet()) {
                if (map.get(key) == 0) {
                    continue;
                }
                deque.offerFirst(key);
                deque.offerLast(key);
                map.put(key, map.get(key) - 2);
                DFS();
                map.put(key, map.get(key) + 2);
                deque.pollFirst();
                deque.pollLast();

            }
        }
    }

    public static String[] solution(String s){
        len = s.length();

        map = new HashMap<>();
        deque = new LinkedList<>();
        res = new ArrayList<>();

        for (String str : s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int odd = 0;
        String mid = "mid";
        for (String key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                mid = key;
                odd++;
            }
        }
        if (odd > 1) {
            return new String[]{};
        }
        if (!mid.equals("mid")) {
            deque.offer(mid);
            map.put(mid, map.get(mid) - 1);
        }

        DFS();
        int size = res.size();
        String[] answer = new String[size];
        for (int i = 0; i < size; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

}
