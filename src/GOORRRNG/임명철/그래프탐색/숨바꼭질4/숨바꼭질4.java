import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] visit = new int[100001];
        int[] path = new int[100001];

        Queue<Integer> q = new LinkedList<Integer>();
        visit[N] = 1;
        path[N] = N;
        q.offer(N);
        int next;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(visit[cur] - 1);

                Stack<Integer> stack = new Stack<>();
                while (path[cur] != cur) {
                    stack.add(cur);
                    cur = path[cur];
                }
                stack.add(N);

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty())
                    sb.append(stack.pop() + " ");
                System.out.println(sb);

                return;
            }

            next = cur << 1;
            if (next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

            next = cur + 1;
            if (next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

            next = cur - 1;
            if (next >= 0 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

        }

    }
}