import java.util.HashSet;
import java.util.Set;
class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		Set<Integer> set = new HashSet<>();
		int countZero=0;
		int collectNum=0;
		for(int a:win_nums){
			set.add(a);
		}
		for(int a:lottos){
			if(set.contains(a)) collectNum++;
			if(a==0) countZero++;
		}
		if(collectNum+countZero<2) answer[0]=6;
		else answer[0]=7-(collectNum+countZero);
		if(collectNum<2) answer[1]=6;
		else answer[1]=7-collectNum;


		return answer;
	}
}
