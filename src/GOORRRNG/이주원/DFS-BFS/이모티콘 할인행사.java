class Solution {
    int[] rates = {10, 20, 30, 40};
    int[] selectedRates;
    int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        selectedRates = new int[emoticons.length];
        search(users, emoticons, 0);
        return answer;
    }
    void search(int[][] users, int[] emoticons, int depth) {
        if(depth == selectedRates.length) {
            calculate(users, emoticons);
            return;
        }
        for(int i = 0; i < rates.length; i++) {
            selectedRates[depth] = rates[i];
            search(users, emoticons, depth+1);
        }
    }
    
    void calculate(int[][] users, int[] emoticons) {
            int profit = 0;
            int addUsers = 0;
            for(int[] user : users) {
                int total = 0;
                for(int i = 0; i < emoticons.length; i++) {
                    if(selectedRates[i] >= user[0])
                        total += emoticons[i] - emoticons[i] * selectedRates[i] / 100;
                }
                if(total >= user[1])
                    addUsers++;
                else
                    profit += total;
            }
        
            if(addUsers > answer[0]) {
                answer[0] = addUsers;
                answer[1] = profit;
            } else if(addUsers == answer[0]) {
                answer[1] = Math.max(answer[1], profit);
            }
        
    }
}