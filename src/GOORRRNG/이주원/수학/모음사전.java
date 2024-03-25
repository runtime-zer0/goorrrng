class Solution {
    public int solution(String word) {
        int[] weights = {781, 156, 31, 6, 1};
        String order = "AEIOU";
        int answer = word.length();
        
        for(int i = 0;  i < word.length(); i++) {
            answer += weights[i] * order.indexOf(word.charAt(i));
        }
        
        return answer;
    }
}