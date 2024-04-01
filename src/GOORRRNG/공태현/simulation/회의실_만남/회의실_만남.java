package GOORRRNG.공태현.simulation.회의실_만남;

public class 회의실_만남 {

    static int[] solution(int[] enter, int[] exit) {
        int n = enter.length;
        int[] answer = new int[n];

        // 문제에서 주어진 사람의 번호를 인덱스와 맞추기 위해서 1씩 감소
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }

        // 사람이 회의실에 들어온 순서를 기록
        int[] enterIdx = new int[n];
        // 사람이 회의실에 온 순서를 기록
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }

        // 사람이 회의실에 들어온 시각을 기록
        int[] enterTime = new int[n];

        // 사람이 회의실에서 나가는 시각을 기록
        int[] exitTime = new int[n];

        int time = 0;
        // 시뮬레이션 시작
        for (int i = 0, j = 0; i < n; i++) {
            // i 번째 사람이 회의실에 입장하기전에 입장한 사람들의 회의실 입장 시각 기록
            while (j < n && j <= enterIdx[exit[i]]) {
                enterTime[enter[j]] = time++;
                j++;
            }
            // i 번째로 회의실에서 나가는 사람이 회의실에서 퇴장하는 시각 기록
            exitTime[exit[i]] = time++;
        }

        // i번째, j 번째 사람이 만나지 않는 경우를 ! 연산을 통하여 만나는 조건으로 변환후 i번째, j 번째 사람이 회의실에서 만난다면 각각 1씩 증가.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!(exitTime[i] < enterTime[j] || exitTime[j] < enterTime[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }
}
