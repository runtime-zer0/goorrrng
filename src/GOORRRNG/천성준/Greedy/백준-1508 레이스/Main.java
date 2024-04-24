import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	static int[] placeArr;
	static public class Info{
		int count;
		String answer;
		public Info(int count,String answer){
			this.count=count;
			this.answer=answer;
		}
	}

	static public String solution(int raceTrack,int refereeCount) {
		int lt=1;
		int rt=raceTrack;
		int mid=0;
		while(lt<=rt){
			mid = (lt+rt)/2;
			if(getRefereeCount(mid,refereeCount).count>=refereeCount){
				lt=mid+1;
			}
			else{
				rt=mid-1;
			}
		}
		return getRefereeCount(rt,refereeCount-1).answer;
	}

	public static Info getRefereeCount(int betweenLength,int refereeCount){
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		int count = 1;
		int beforeIndex=0;
		for (int i = 1; i <placeArr.length ; i++) {
			if((placeArr[i]-placeArr[beforeIndex])>=betweenLength&&refereeCount!=0){
				count++;
				beforeIndex=i;
				sb.append(1);
				refereeCount--;
			}
			else{
				sb.append(0);
			}
		}

		return new Info(count,sb.toString());
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int raceTrack = Integer.parseInt(st.nextToken());
		int refereeCount = Integer.parseInt(st.nextToken());
		int placeCount =Integer.parseInt(st.nextToken());
		placeArr = new int[placeCount];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0;st.hasMoreTokens(); i++) {
			placeArr[i]=Integer.parseInt(st.nextToken());
		}
		System.out.println(solution(raceTrack,refereeCount));

	}
}
