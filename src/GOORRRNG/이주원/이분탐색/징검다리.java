import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);
        long left = 0, right = distance+1, mid;
        while(left+1 < right) {
            
            mid = (left + right) / 2;
            
            int prev = 0, crush = 0;
            
            for(int rock : rocks) {
                if(rock - prev < mid)
                    crush++;
                else
                    prev = rock;
                
                if(crush > n) break;
            }
            if(distance - prev < mid)
                crush++;
            
            if(crush <= n)
                left = mid;
            else 
                right = mid;
        }
        
        return (int) left;
    }
}