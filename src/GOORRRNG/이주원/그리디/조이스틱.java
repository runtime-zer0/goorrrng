class Solution {
    public int solution(String name) {
        int move = name.length() - 1;
        int answer = 0;
        
        for(int i = 0; i < name.length(); i++) {
            answer += getCount(name.charAt(i));
            int j = i + 1;
            while(j < name.length() && name.charAt(j) == 'A')
                j++;
            
            move = Math.min(move, i*2 + name.length() - j);
            move = Math.min(move, (name.length() - j) * 2 + i);
        }
        answer += move;
        return answer;
    }
    
    int getCount(char target) {
        int upward = target - 'A';
        int downward = 'Z' - target + 1;
        return Math.min(upward, downward);
    }
}