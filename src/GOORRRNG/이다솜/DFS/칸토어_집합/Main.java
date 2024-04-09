package GOORRRNG.이다솜.DFS.칸토어_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String input;

         while ((input = br.readLine()) != null) {
             int n = Integer.parseInt(input);

             int length = (int) Math.pow(3, n);

             sb = new StringBuilder();
             for (int i = 0; i < length; i++) {
                 sb.append("-");
             }

             dfs(0, length);
             System.out.println(sb);
         }
         br.close();
    }

    public static void dfs(int start, int size) {
        if (size == 1) {
            return;
        }

        int len = size / 3;

        for (int i = start + len; i < start + 2 * len; i++) {
            sb.setCharAt(i, ' ');
        }

        dfs(start, len);
        dfs(start +2 * len, len);
    }
}
