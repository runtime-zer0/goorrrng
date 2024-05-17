import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        // 이분 탐색 (파라메트릭 서치) 
        // mid의 위치를 막을 수 있다면 start = mid + 1
        // mid의 위치를 막을 수 없다면 end = mid
        // left가 right 보다 크거나 같아지는 경우 -> 종료
        
        int start = 0;
        int end = enemy.length;
        
        while(start < end){
            int mid = start + (end - start)/2;
            
            // mid의 위치를 막을 수 있는 지 확인
            if (isPossible(mid, k, enemy, n)){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    private boolean isPossible(int mid, int k, int[] enemy, int n){
        int[] tmp = Arrays.copyOfRange(enemy, 0, mid+1);
        Arrays.sort(tmp);
        
        for(int i = 0; i < tmp.length; i++){
            if(tmp[i] <= n){
                n -= tmp[i];
                continue;
            }
            return k >= tmp.length - i;
        }
        return true;
        
    }
}
