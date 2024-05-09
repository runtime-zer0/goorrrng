package 상어_초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer[]> hashMap = new HashMap<>();
    static int[][] seat;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        seat = new int[n][n];

        for (int i = 0; i < n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());

            hashMap.put(student, new Integer[] {f1, f2, f3, f4});
            putStudent(student);
        }

        int sum = 0;
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat.length; j++) {

                int cnt = 0;
                Integer[] friends = hashMap.get(seat[i][j]);

                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];

                    if (ny < 0 || nx < 0 || ny >= seat.length || nx >= seat.length) continue;

                    int point = seat[ny][nx];

                    for (int l = 0; l < 4; l++) {
                        if (point == friends[l]) cnt++;
                    }
                }
                switch (cnt) {
                    case 1: sum += 1; break;
                    case 2: sum += 10; break;
                    case 3: sum += 100; break;
                    case 4: sum += 1000; break;
                }
            }
        }
        System.out.println(sum);
    }

    private static void putStudent(int student) {
        Integer[] friends = hashMap.get(student);

        int f1 = friends[0];
        int f2 = friends[1];
        int f3 = friends[2];
        int f4 = friends[3];

        ArrayList<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat.length; j++) {
                int fCount = 0, emptySeat = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (nx < 0 || ny < 0 || nx >= seat.length || ny >= seat.length) continue;

                    int point = seat[ny][nx];

                    if (point == f1 || point == f2 || point == f3 || point == f4) fCount++;
                    if (point == 0) emptySeat++;
                }
                list.add(new Integer[] {fCount, emptySeat, i, j});
            }
        }
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] < o2[0]) return 1;
                else if (o1[0] == o2[0]) {
                    if (o1[1] < o2[1]) return 1;
                    else if (o1[1] == o2[1]) {
                        if (o1[2] > o2[2]) return 1;
                        else if (o1[2] == o2[2]) {
                            if (o1[3] > o2[3]) return 1;
                        }
                    }
                }
                return -1;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[3];
            int y = list.get(i)[2];

            if (seat[y][x] == 0) {
                seat[y][x] = student;
                return;
            }
        }
    }
}
