import java.util.*;

class Point{
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n,m;
    static char[][] map;
    static ArrayList<Point> BeakJo;
    static Queue<Point> wQ,bQ;
    static boolean[][] checked;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        checked = new boolean[n][m];
        BeakJo = new ArrayList();
        bQ = new LinkedList<>();
        wQ = new LinkedList<>();

        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);

                //여기서 L의 위치를 '.'으로 변환해주지 않는다면, 두번째 백조 위치를 bQ에 담을 수가 없어서 무한루프를 돌게된다.
                if(map[i][j] == 'L') {
                    BeakJo.add(new Point(i, j));
                    map[i][j] = '.';
                }
                if(map[i][j] == '.') {
                    wQ.offer(new Point(i,j));
                }
            }
        }

        //시간을 줄이기 위해서 백조의 위치를 계속 갱신시켜줘야함
        //첫번째 백조의 위치를 bQ에 담아놓는다.
        bQ.add(new Point(BeakJo.get(0).x, BeakJo.get(0).y));
        checked[BeakJo.get(0).x][BeakJo.get(0).y] = true;

        //백조가 다른 백조를 만날수 있는가?(move()) 없다면 얼음을 녹여준다.(melting())
        int time = 0;
        while(true){
            if(move()) break;
            melting();
            time++;
        }
        System.out.println(time);
    }

    //nextQ는 백조가 움직일때 다음 위치가 'X'일때 좌표를 임시저장하는 Queue이다.
    //임시저장을 하는 이유는 bQ에는 백조의 위치만을 담을 것이고, while문에서 bQ가 비어있는지를 판단하면서 반복하기때문에
    //'X'일때 위치를 다른 Queue에 저장을 해 놓은 후 반복문을 빠져나와서 그 때 백조의 위치를 갱신해주기위함이다.
    public static boolean move(){
        Queue<Point> nextQ = new LinkedList<>();
        while(!bQ.isEmpty()){
            Point curr = bQ.poll();

            //다른 백조를 만났을 때 true를 반환한다.
            if(curr.x == BeakJo.get(1).x && curr.y == BeakJo.get(1).y) return true;

            for(int dir = 0; dir<4; dir++){
                int nx = curr.x + dx[dir];
                int ny = curr.y + dy[dir];

                if(nx <0 || ny <0 || nx > n-1 || ny > m-1 || checked[nx][ny]) continue;

                checked[nx][ny] = true;

                //맵이 '.'일 때, 즉 백조가 움직일 수 있을 때는 bQ에 계속 담아준다.
                if(map[nx][ny] == '.'){
                    bQ.offer(new Point(nx,ny));
                }
                //'X'일때는 좌표를 임시저장한다.
                else if(map[nx][ny] == 'X'){
                    nextQ.offer(new Point(nx,ny));
                }
            }
        }

        //임시저장한 좌표를 bQ에 넣어 다음 move를 실행할 때 위치를 갱신해준다.
        bQ = nextQ;
        return false;
    }

    //물의 위치를 담아서 물의 사이즈만큼 반복한다. 여기서 while(!wQ.isEmpty())로 반복문을 돌지 않는 이유는
    //map[nx][ny] 가 'X'일 때 '.'으로 바꿔주는데 이와같은 과정에서 while(!wQ.isEmpty())를 사용해서 반복한다면, 모든 좌표가 '.'이 될때까지 반복하게 된다.
    public static void melting(){
        int size = wQ.size();

        for(int i=0; i<size; i++){
            Point curr = wQ.poll();

            for(int dir=0; dir<4; dir++){
                int nx = curr.x+dx[dir];
                int ny = curr.y+dy[dir];

                if(nx <0 || ny<0 || nx > n-1 || ny > m-1) continue;

                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    wQ.offer(new Point(nx,ny));
                }
            }
        }
    }
}