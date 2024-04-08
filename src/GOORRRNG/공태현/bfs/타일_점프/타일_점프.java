package GOORRRNG.공태현.bfs.타일_점프;

import java.util.LinkedList;
import java.util.Queue;

public class 타일_점프 {

    static boolean[] visited;
    static Queue<Integer> queue;

    static int BFS(int[] nums) {
        queue = new LinkedList<>();
        queue.offer(0);

        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();

                for (int j = 1; j <= nums[cur]; j++) {
                    int next = cur + j;

                    if (next == nums.length - 1) {
                        return level + 1;
                    }

                    if (!visited[next] && next < nums.length) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public static int solution(int[] nums) {
        visited = new boolean[nums.length];

        return BFS(nums);
    }
}
