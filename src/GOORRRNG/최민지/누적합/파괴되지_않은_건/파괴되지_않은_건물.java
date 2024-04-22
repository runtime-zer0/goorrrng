import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        // 누적합 배열
        int[][] sum = new int[board.length+1][board[0].length+1];

        // skill 정리
        for(int[] s : skill){

            int r1 = s[1];
            int c1 = s[2];

            int r2 = s[3];
            int c2 = s[4];

            int degree = (s[0] == 1) ? -s[5] : s[5];

            // 일반화
            sum[r1][c1] += degree;
            sum[r1][c2+1] += -degree;
            sum[r2+1][c1] += -degree;
            sum[r2+1][c2+1] += degree;
        }

        // 세로로 누적합
        for(int c = 0; c < board[0].length+1; c++){
            for(int r = 0; r < board.length; r++){
                sum[r+1][c] += sum[r][c];
            }
        }

        // 가로로 누적합
        for(int r = 0; r < board.length+1; r++){
            for(int c = 0; c < board[0].length; c++){
                sum[r][c+1] += sum[r][c];
            }
        }

        // sum 배열과 기존 board배열을 더한다.
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] += sum[r][c];

                // 파괴되지 않은 건물 개수 세기
                if(board[r][c] > 0) answer++;
            }
        }

        return answer;
    }
}
