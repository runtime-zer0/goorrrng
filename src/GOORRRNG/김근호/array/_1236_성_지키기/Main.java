package GOORRRNG.김근호.array._1236_성_지키기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for(int i=0; i<n; i++){
            arr[i] = sc.next().toCharArray();
        }
        int rowCnt = 0;
        int colCnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]=='X') {
                    rowCnt++;
                    break;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[j][i]=='X') {
                    colCnt++;
                    break;
                }
            }
        }
        int answer = Math.max(n-rowCnt, m-colCnt);
        System.out.println(answer);
    }
}