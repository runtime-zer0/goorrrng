package 분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        String s = Integer.toString(n); // 생성자의 최소 수를 구하기 위한 s
        String str = "";
        int sum = 0;
        int m = n - (9 * s.length());

        while (m <= n) {
            sum = 0;
            m++;
            str = String.valueOf(m);

            for (int i = 0; i < str.length(); i++) {
                sum += (int) str.charAt(i) - '0';
            }

            sum += m;

            if (sum == n) {
                System.out.println(m);
                return;
            }
        }
        System.out.println(0);
    }
}
