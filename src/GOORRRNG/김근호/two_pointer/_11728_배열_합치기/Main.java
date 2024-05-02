package GOORRRNG.김근호.two_pointer._11728_배열_합치기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n + m];
        int l=0, r=0, idx=0;
        while (l < n && r < m) {
            if (arrA[l]<=arrB[r]) ans[idx++]= arrA[l++];
            else ans[idx++] = arrB[r++];
        }

        while (l < n) ans[idx++] = arrA[l++];
        while (r < m) ans[idx++] = arrB[r++];

        for (int i : ans) {
            bw.write(i + " ");
        }

        bw.flush();
    }
}
