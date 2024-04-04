package GOORRRNG.공태현.dfs.IP주소;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IP주소 {

    static Deque<Integer> stack;
    static List<String> res;

    public static void DFS(int start, String str) {
        if (stack.size() == 4 && start == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (Integer val : stack) {
                sb.append(val).append(".");
            }
            res.add(sb.substring(0, sb.length() - 1));

        } else {
            for (int i = start; i < str.length(); i++) {
                if (str.charAt(start) == '0' && i > start) {
                    return;
                }
                int num = Integer.parseInt(str.substring(start, i + 1));
                if (num > 255) {
                    return;
                }
                stack.offer(num);
                DFS(i + 1, str);
                stack.pollLast();
            }
        }
    }

    public static String[] solution(String s){

        stack = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);

        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}
