package GOORRRNG.예진희.인프런.섬나라_아일랜드_BFS;

import java.util.*;

// 좌표를 나타내는 클래스
class Point{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main {
    static int answer=0;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>(); // 큐 생성

    public void BFS(int x, int y, int[][] board){
        queue.add(new Point(x, y)); // 시작점을 큐에 추가
        while(!queue.isEmpty()){
            Point pos = queue.poll();
            for(int i=0; i<8; i++){
                int nx=pos.x+dx[i];
                int ny=pos.y+dy[i];
                // 유효한 범위 내에 있고, 땅이면(1), 방문 표시 후 큐에 추가
                if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]==1){
                    board[nx][ny]=0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board){
        // 보드 전체를 탐색
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                // 땅(1)을 발견하면 섬의 개수를 증가시키고, 해당 땅을 시작으로 BFS 호출
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0; // 방문한 땅을 0으로 표시
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
