package GOORRRNG.공태현.simulation.과일_가져가기;

public class 과일_가져가기 {

    static int getMinVal(int[] fruit) {
        int minVal = Integer.MAX_VALUE;
        for (int val : fruit) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    static int getMinValIdx(int[] fruit) {
        int minVal = getMinVal(fruit);
        for (int i = 0; i < fruit.length; i++) {
            if (minVal == fruit[i]) {
                return i;
            }
        }
        return -1;
    }

    static boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int minVal = getMinVal(fruit);
        for (int val : fruit) {
            if (val == minVal) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int solution(int[][] fruit) {
        int n = fruit.length;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] || !isMinUnique(fruit[i])) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (visited[j] || !isMinUnique(fruit[j])) {
                    continue;
                }
                int fruitA = getMinValIdx(fruit[i]);
                int fruitB = getMinValIdx(fruit[j]);
                if (fruitA != fruitB && fruit[i][fruitB] > 0 && fruit[j][fruitA] > 0) {
                    if (fruit[i][fruitA] + 1 <= fruit[i][fruitB] - 1 && fruit[j][fruitB] + 1 <= fruit[j][fruitA] - 1) {
                        fruit[i][fruitA]++;
                        fruit[i][fruitB]--;
                        fruit[j][fruitB]++;
                        fruit[j][fruitA]--;
                        visited[i] = true;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        int answer = 0;
        for (int[] val : fruit) {
            answer += getMinVal(val);
        }

        return answer;
    }
}
