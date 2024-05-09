import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] people;
	static List<int[]> partyPeople = new ArrayList<>();
	static int[] truePeople;

	static HashSet<Integer> trueSet = new HashSet<>();


	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			people[b] = a;
	}

	public static int find(int x) {
		if (people[x] == x)
			return x;
		else
			return find(people[x]);
	}

	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		people=new int[n+1];
		for (int i = 0; i <= n; i++) {
			people[i]=i;
		}
		st= new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		truePeople = new int[a];
		for (int i = 0; i < a; i++) {
			truePeople[i]=Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st= new StringTokenizer(br.readLine()," ");
			a=Integer.parseInt(st.nextToken());
			int[] l = new int[a];
			for (int j = 0; j < a; j++) {
				l[j]=Integer.parseInt(st.nextToken());
				if(j!=0) union(l[0],l[j]);
			}
			partyPeople.add(l);
		}
		for(int t:truePeople){
			trueSet.add(find(t));
		}
	}
	public static int solution(){
		int count = 0;
		for(int[] l:partyPeople){
			boolean flag=true;
			for (int i = 0; i < l.length; i++) {
				if(trueSet.contains(find(l[i]))){
					flag=false;
				}
			}
			if(flag) count++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solution());
	}
}
