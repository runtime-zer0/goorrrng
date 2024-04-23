import java.util.*;

public class Main {
    static int n,m,r,c,d;
    static int[][] board;
    static int answer = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        board = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int check = sc.nextInt();
                if(check == 1){
                    board[i][j] = 3;
                }else{
                    board[i][j] = 0;
                }
            }
        }

        clean(d);
        System.out.println(answer);
    }

    public static void clean(int s){
        while (true) {
            if(board[r][c] == 0){
                board[r][c] = 1;
                answer++;
            }

            //다 막혀있거나? 청소를 한 지역이거나
            if (board[r + 1][c] != 0 && board[r - 1][c] != 0 && board[r][c + 1] != 0 && board[r][c - 1] != 0) {
                back(s);

                //후진했는데 벽을 마주친 경우
                if(board[r][c] == 3){
                    return;
                }

                continue;
            }

            //반시계방향 회전
            s = (s+3) % 4;

            //전진
            go(s);

            //벽이거나 청소한 곳이라면 후진
            if(board[r][c] != 0){
                back(s);
            }
        }
    }

    public static void go(int s){
        if(s == 0){
            r--;
        }
        if(s == 1){
            c++;
        }
        if(s == 2){
            r++;
        }
        if(s == 3){
            c--;
        }
    }

    public static void back(int s){
        if(s == 0){
            r++;
        }
        if(s == 1){
            c--;
        }
        if(s == 2){
            r--;
        }
        if(s == 3){
            c++;
        }
    }

}