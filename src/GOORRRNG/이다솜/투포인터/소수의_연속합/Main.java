package GOORRRNG.이다솜.투포인터.소수의_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static boolean[] primeB;
    static ArrayList<Integer> primeI;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        isPrime(n); // n까지의 소수 배열 구하기

        primeI = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (primeB[i]) primeI.add(i); // 소수면 리스트에 담기
        }

        int lt = 0, rt = 0, sum = 0, answer = 0;
        while (true) {  // 부분합 구하기
            if (sum >= n) sum -= primeI.get(lt++);
            else if (rt == primeI.size()) break;
            else sum += primeI.get(rt++);

            if (sum == n) answer++;
        }

        System.out.println(answer);
        br.close();
    }

    static void isPrime (int n) {  //에라토스테네스의 체를 이용해서 소수 배열 구하는 클래스
        primeB = new boolean[n + 1];

        for (int i = 2; i < primeB.length; i++) {
            primeB[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (primeB[i]) {
                for (int j = i*i; j <= n; j += i) {
                    primeB[j] = false;
                }
            }
        }
    }
}
