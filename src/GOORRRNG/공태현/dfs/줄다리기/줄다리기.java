package GOORRRNG.공태현.dfs.줄다리기;

import java.util.Deque;
import java.util.LinkedList;

public class 줄다리기 {
    static boolean[] visited;
    static int[][] relation;
    static int answer;
    static Deque<Integer> pm;
    public static void DFS(int L){
        if(L == 7){
            answer++;
        }
        else{
            for(int i = 1; i < 8; i++){
                if(!pm.isEmpty() && relation[pm.peek()][i] == 1){
                    continue;
                }
                if(!visited[i]){
                    visited[i] = true;
                    pm.push(i);
                    DFS(L + 1);
                    visited[i] = false;
                    pm.pop();
                }
            }
        }
    }

    public static int solution(int[][] state){
        answer = 0;
        pm = new LinkedList<>();
        relation = new int[8][8];
        for(int[] x : state){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        visited = new boolean[8];
        DFS(0);
        return answer;
    }
}
