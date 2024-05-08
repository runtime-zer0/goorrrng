package 스택.스택_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();

        int idx = 0, num = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        while(idx < n) {
            if (!stack.empty() && arr[idx] < stack.get(stack.size() - 1)) {
                break;
            } else if (!stack.empty() && arr[idx] == stack.get(stack.size() - 1)) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                while (num <= n) {
                    if (arr[idx] != num) {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                    } else {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                        break;
                    }
                }
            }
        }
        if (idx == n) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }

}
