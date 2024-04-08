package 정렬.좌표_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sortedArr = new int[n];
        hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);
        solution(sortedArr);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(hm.get(i)).append(' ');
        }

        System.out.println(sb);

        br.close();
    }

    public static void solution (int[] sortedArr) {
        int answer = 0;
        for (int key : sortedArr) {
            if (!hm.containsKey(key)) {
                hm.put(key, answer);
                answer++;
            }
        }
    }
}

