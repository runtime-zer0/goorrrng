package GOORRRNG.예진희.그리디.백준_1339;

import java.io.*;
import java.util.*;
public class Baek_1339 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26]; //알파벳 수 만큼 배열 선언

        Arrays.fill(alpha, 0);

        for(int i=0; i<n; i++) {
            char input[] = br.readLine().toCharArray();
            int pos = 1;

            for(int j = input.length -1; j>=0; j--) {
                alpha[input[j] - 'A'] += Integer.valueOf(pos);
                pos*=10;
            }
        }

        // Collections.reverseOrder는 Integer로 배열을 선언.
        Arrays.sort(alpha, Collections.reverseOrder());

        int value = 9, answer = 0;

        for(int i=0; i<alpha.length; i++) {
            if(alpha[i] == 0) { //더 이상 계산할 단어가 없으면 종료
                break;
            }
            answer += alpha[i] * value--;
        }

        System.out.println(answer);

    }
}
