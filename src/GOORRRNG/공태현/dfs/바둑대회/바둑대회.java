package GOORRRNG.공태현.dfs.바둑대회;

import java.util.ArrayList;
import java.util.List;

public class 바둑대회 {
    static int[] visited;
    static int len, answer, sumWhite, sumBlack;
    static List<Integer> white, black;

    public static void DFS(int level, int s, int[][] cans) {
        if (level == len / 2) {
            white = new ArrayList<>();
            black = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (visited[i] == 1) {
                    white.add(i);
                } else {
                    black.add(i);
                }
            }
            sumWhite = 0;
            sumBlack = 0;
            for (int i = 0; i < len / 2; i++) {
                sumWhite += cans[white.get(i)][0];
                sumBlack += cans[black.get(i)][1];
            }

            answer = Math.min(answer, Math.abs(sumWhite - sumBlack));
        } else {
            for (int i = s; i < len; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    DFS(level + 1, i + 1, cans);
                    visited[i] = 0;
                }
            }
        }
    }

    public static int solution(int[][] cans){
        len = cans.length;

        answer = Integer.MAX_VALUE;

        visited = new int[len];
        DFS(0, 0, cans);

        return answer;
    }

}
