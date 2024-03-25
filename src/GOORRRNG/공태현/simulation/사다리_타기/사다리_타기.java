package GOORRRNG.공태현.simulation.사다리_타기;

public class 사다리_타기 {
    static char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }

        for (int[] line : ladder) {
            char tmp;
            for (int val : line) {
                tmp = answer[val];
                answer[val] = answer[val - 1];
                answer[val - 1] = tmp;
            }

        }

        return answer;
    }
}
