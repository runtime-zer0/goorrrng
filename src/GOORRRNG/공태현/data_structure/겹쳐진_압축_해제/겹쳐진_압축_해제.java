package GOORRRNG.공태현.data_structure.겹쳐진_압축_해제;

import java.util.Deque;
import java.util.LinkedList;

public class 겹쳐진_압축_해제 {
    public static String solution(String s){
        String answer = "";
        Deque<String> st = new LinkedList<>();
        for(Character x : s.toCharArray()){
            if(x == ')'){
                String tmp = "";

                while(!st.isEmpty()){
                    String c = st.pollFirst();

                    if(c.equals("(")){
                        String num = "";
                        while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                            num = st.pollFirst() + num;
                        }

                        String res = "";
                        int cnt = 0;
                        if(num.equals("")) {
                            cnt = 1;
                        } else {
                            cnt = Integer.parseInt(num);
                        }

                        for(int i = 0; i < cnt; i++) {
                            res += tmp;
                        }

                        st.offerFirst(res);
                        break;
                    }

                    tmp = c + tmp;
                }
            }
            else {
                st.offerFirst(String.valueOf(x));
            }
        }
        for(String x : st) {
            answer += x;
        }

        return answer;
    }
}
