import java.util.*;
import java.util.regex.*;

class Solution {

    // 접근 방법 : DFS를 이용하여 가능한 조합 생성, HashSet을 사용해 중복 방지
    private static ArrayList<ArrayList<String>> arr; // 불량 사용자 목록에 대한 각각의 가능한 사용자 아이디 목록을 저장한다. 
    private static HashSet<HashSet<String>> answer; // 유효한 조합 저장

    public int solution(String[] user_id, String[] banned_id) {
        arr = new ArrayList<>();
        answer = new HashSet<>();

        // 불량 사용자 목록에 대해 반복
        for(String banned : banned_id){
            ArrayList<String> temp = new ArrayList<>();
            for(String user : user_id){
                if(user.length() != banned.length()) continue; // 길이가 다르면 바로 넘어감
                else if(Pattern.matches(banned.replace('*','.'), user)){
                    temp.add(user);
                    // 패턴 비교 후 리스트에 추가
                }
            }
            arr.add(temp); // 각 불량 사용자 목록에 대해 가능한 사용자 아이디 목록들을 arr에 추가
        }

        dfs(new HashSet<String>(), 0);
        return answer.size();
    }

    // 가능한 조합 모두 생성
    private static void dfs(HashSet<String> s, int depth){
        // 종료 조건
        if(depth == arr.size()){
            // arr를 모두 확인하면 현재까지 선택된 집합을 정답에 추가하고 종료
            answer.add(new HashSet<>(s));
            return;
        }

        // 현재 탐색 중인 불량 사용자 목록에서 가능한 모든 사용자 아이디 반복
        for(String user : arr.get(depth)){
            // 중복되지 않는다면
            if(s.add(user)){
                // 다음 단계
                dfs(s, depth + 1);
                // 백트래킹
                s.remove(user);
            }
        }
    }
}
