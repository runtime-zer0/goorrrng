package 진법_변환2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (n > 0) {
            if (n % b < 10) sb.append(n % b);
            else sb.append((char) ((n % b) + 55));

            n /= b;
        }

        sb.reverse();
        System.out.println(sb);

        br.close();
    }
}
