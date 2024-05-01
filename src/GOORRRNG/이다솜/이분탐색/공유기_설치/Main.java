package 공유기_설치;

import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {

    static int n;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) house[i] = parseInt(br.readLine());
        Arrays.sort(house);

        int lt = 1;
        int rt = house[n - 1] - house[0] + 1;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            int count = installWifi(mid);
            if (count < m) lt = mid;
            else lt = mid + 1;
        }

        System.out.println(lt - 1);

        br.close();
    }

    static int installWifi(int distance) {
        int lastLoc = house[0];
        int count = 1;

        for (int i = 0; i < n; i++) {
            int nowLoc = house[i];

            if (nowLoc - lastLoc >= distance) {
                count++;
                lastLoc = nowLoc;
            }
        }
        return count;
    }
}
