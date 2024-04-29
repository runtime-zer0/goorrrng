import java.util.*;

class Solution {

    private static List<List<Integer>> answer;

    public List<List<Integer>> combinationSum3(int k, int n) {
        answer = new ArrayList<List<Integer>>();

        // 1 ~ 9 까지 수 중 k개의 숫자로 합이 n이 되어야 함.
        dfs(k, n, 1, new ArrayList<Integer>());

        return answer;
    }

    private static void dfs(int k, int n, int idx, List<Integer> nowList){
      // 종료조건
      if(nowList.size() == k){
        if(n == 0){
          // nowList 값은 계속해서 수정되기 때문에 복사본을 answer에 넣어줘야 한다.
          answer.add(new ArrayList<Integer>(nowList));
          return;
        }
      }

      // 조합
      for(int i = idx; i <= 9; i++){
        nowList.add(i);
        dfs(k, n-i, i+1, nowList);
        nowList.remove(nowList.size()-1); // 백트래킹
      }
    }
}
