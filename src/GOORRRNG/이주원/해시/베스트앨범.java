import java.util.*;

class Solution {
    
    private static class Category {
        int totalPlays;
        PriorityQueue<Integer> songs;
            
        public Category(int totalPlays, PriorityQueue<Integer> songs) {
            this.totalPlays = totalPlays;
            this.songs = songs;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Category> categoryByGenre = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if(categoryByGenre.get(genres[i]) == null)
                categoryByGenre.put(genres[i], new Category(0, new PriorityQueue<>(
                (o1, o2) -> plays[o2] - plays[o1]
                )));
            
            Category category = categoryByGenre.get(genres[i]);
            category.totalPlays += plays[i];
            category.songs.add(i);
        }
        
        List<Integer> answer = new ArrayList<>();
        Category[] categorys = categoryByGenre.values().toArray(new Category[0]);
        Arrays.sort(categorys, (o1, o2) -> o2.totalPlays - o1.totalPlays);
        
        for(Category category : categorys) {
            int i = 0;
            while(!category.songs.isEmpty() && i++ < 2) {
                answer.add(category.songs.poll());
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}