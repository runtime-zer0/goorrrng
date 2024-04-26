import java.util.*;

public class Main {
    public static int R, C;
    public static char[][] map;
    public static Queue<Node> jihun_q = new LinkedList<>();
    public static Queue<Node> fire_q = new LinkedList<>();
    public static int time = 0;
    public static boolean resultflag = false;
    public static int[] dx= {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        R = sc.nextInt();
        C =	sc.nextInt();
        map = new char[R][C];

        for(int i=0;i<R;i++) {
            String str = sc.next();
            for(int j=0;j<C;j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') {
                    jihun_q.add(new Node(i, j));
                }else if(map[i][j] == 'F') {
                    fire_q.add(new Node(i,j));
                }
            }
        }


        int time = 0;
        while(true) {
            time++;
            int fire_q_size = fire_q.size();
            for(int i=0;i<fire_q_size;i++) {
                Node temp = fire_q.poll();
                int x = temp.x;
                int y = temp.y;
                for(int dir=0;dir<4;dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if( nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(map[nx][ny] == 'J' || map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        fire_q.offer(new Node(nx, ny));
                    }
                }
            }

            int jiun_q_size = jihun_q.size();
            for(int i=0;i<jiun_q_size;i++) {
                Node temp = jihun_q.poll();
                int x = temp.x;
                int y = temp.y;
                for(int dir=0;dir<4;dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if( nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(time);
                        return ;
                    }
                    if(map[nx][ny] == '.') {
                        jihun_q.offer(new Node(nx, ny));
                        map[nx][ny] = 'J';
                    }
                }
            }

            if(jihun_q.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return ;
            }


        }
    }

}

class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x=x;
        this.y=y;
    }
}