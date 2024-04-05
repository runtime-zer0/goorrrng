package GOORRRNG.공태현.dfs.알파코드;

public class 알파코드 {

    static int[] memo;

    public static int DFS(int start, String str) {
        if (memo[start] != 0) {
            return memo[start];
        }
        if (start < str.length() && str.charAt(start) == '0') {
            return 0;
        }
        if (start == str.length() - 1 || start == str.length()) {
            return 1;
        } else {
            int res = DFS(start + 1, str);
            int tmp = Integer.parseInt(str.substring(start, start + 2));
            if (tmp <= 26) {
                res += DFS(start + 2, str);
            }
            return memo[start] = res;

        }
    }

    public static int solution(String s){
        memo = new int[s.length() + 1];

        return DFS(0, s);
    }
}
