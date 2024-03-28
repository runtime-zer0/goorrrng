import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        
        for(String num : phone_book) {
            set.add(num);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        
        return true;
    }
}