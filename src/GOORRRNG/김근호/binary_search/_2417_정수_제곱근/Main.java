package GOORRRNG.김근호.binary_search._2417_정수_제곱근;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long binarySearch(long n){
        long l = 0, r = n, q = Long.MAX_VALUE;
        while(l<=r) {
            long m = (l + r) / 2;
            if(Math.pow(m, 2) >= n) {
                q = m;
                r = m - 1;
            } else l = m + 1;
        }
        return q;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(binarySearch(n));
    }
}
