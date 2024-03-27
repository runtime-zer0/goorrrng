import java.io.*;
import java.util.*;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] P = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            totalTime += P[i] * (n - i);
        }

        bw.write(Integer.toString(totalTime));

        br.close();
        bw.flush();
        bw.close();
    }
}