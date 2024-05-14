package GOORRRNG.공태현.graph.소문난_칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소문난_칠공주 {
    static char[][] classroom = new char[5][5];
    static int[] combination = new int[7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    static void makeCombination(int level, int start, int cntY) {
        if(cntY >= 4) {
            return;
        }

        if(level ==7){
            if (check()) {
                answer++;
            }
            return;
        }
        //백트래킹은 0 ~ 24지만, 배열은 5*5 2차원이다.
        //즉, 5로 나눈 몫을 행으로, 나머지를 열로 설정해주면 5*5 행렬을 표현 가능하다.
        for(int i = start ; i < 25 ; i++) {
            combination[level] = i;
            if (classroom[i / 5][i % 5] == 'Y') {
                makeCombination(level + 1, i + 1, cntY + 1);
            } else {
                makeCombination(level + 1, i + 1, cntY);
            }
        }
    }

    static boolean check() {

        ArrayList<Integer> AdjacentCheck = new ArrayList<>();
        for(int a: combination){
            AdjacentCheck.add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(combination[0]);
        while(!queue.isEmpty()) {
            int studentNum = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = studentNum / 5 + dx[i];
                int ny = studentNum % 5 + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (AdjacentCheck.contains(nx * 5 + ny)) {
                        AdjacentCheck.remove(Integer.valueOf(nx * 5 + ny));
                        queue.offer(nx * 5 + ny);
                    }
                }
            }
        }

        return AdjacentCheck.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().toCharArray();
        }

        makeCombination(0, 0, 0);
        System.out.println(answer);
    }
}
