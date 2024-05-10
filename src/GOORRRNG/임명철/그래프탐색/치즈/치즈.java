import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static int m;

    static int[][] map;
    static boolean[][] visited;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    static List<Integer> list = new ArrayList<>(); // 치즈 개수가 들어갈 list

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input end

        boolean flag = true; // 모든 치즈가 녹아 없어지면 flag는 false가 된다.
        int time = 0; // 시간
        int firstCount = getCount(); // 초기상태 치즈의 개수

        while (flag) {
            time++;

            bfs(new Location(0, 0));

            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], false); // 다음 시간에 치즈를 녹이기 위해 visited 배열 전부 false를 넣어줌

            int count = getCount();

            if (count == 0)
                flag = false;
            else
                list.add(count);
        }

        System.out.println(time);

        if (list.size() > 0) // 치즈가 전부 녹는데 2시간 이상인 경우
            System.out.println(list.get(list.size() - 1));
        else // 1시간만에 치즈가 다 녹는 경우 혹은 치즈가 하나도 없을 때.
            System.out.println(firstCount);

    }

    // 0.0 부터 돌려서 1을 만나면 2로

    static void bfs(Location location) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.x][location.y] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) { // 치즈의 모서리를 일단 2로 변경한다.
                            map[nx][ny] = 2;
                            visited[nx][ny] = true;
                        }
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            queue.add(new Location(nx, ny));
                        }
                    }
                }
            }
        }

        removeCheese(); // 배열의 값이 2면 치즈의 모서리이므로 0으로 바꾸어 녹여버림
    }

    static void removeCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
}