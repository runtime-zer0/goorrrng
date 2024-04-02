package GOORRRNG.공태현.dfs.가장_가까운_큰수;

import java.util.Arrays;

public class 가장_가까운_큰수 {

    static boolean[] visited;
    static int len, origin, answer;
    static int[] num;
    static int[] res;
    static boolean findLargeDecimal;

    static public void DFS(int level) {
        if (findLargeDecimal) {
            return;
        }

        if (level == len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(res[i]);
            }

            int tmp = Integer.parseInt(sb.toString());
            if (tmp <= origin) {
                return;
            } else {
                answer = tmp;
                findLargeDecimal = true;
            }

        } else {
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    res[level] = num[i];
                    DFS(level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static public int solution(int n) {
        origin = n;

        String str = String.valueOf(n);
        String[] split = str.split("");

        len = str.length();
        num = new int[len];
        visited = new boolean[len];
        res = new int[len];

        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(num);

        answer = Integer.MAX_VALUE;
        findLargeDecimal = false;
        DFS(0);

        if (findLargeDecimal) {
            return answer;
        }
        return -1;
    }
}
