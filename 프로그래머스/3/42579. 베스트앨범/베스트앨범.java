import java.util.*;

class Solution {
    Map<String, Integer> totalMap = new HashMap<>();
    List<String> genreList = new ArrayList<>();
    Map<String, List<Song>> eachMap = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        
        for (int i = 0; i < genres.length; i++) {
            eachMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }
        
        for (String genre : eachMap.keySet()) {
            Collections.sort(eachMap.get(genre), (s1, s2) -> s2.plays - s1.plays);
            totalMap.put(genre, getTotalPlays(eachMap.get(genre)));
            genreList.add(genre);
        }
        
        int sum = 0;
        for (String g : genreList) {
            int c = 0;
            for (Song s : eachMap.get(g)) {
                if (c > 1) {
                    break;
                }
                c++;
            }
            sum += c;
        }
        
        int[] answer = new int[sum];
        
        Collections.sort(genreList, (s1, s2) -> totalMap.get(s2) - totalMap.get(s1));
        int i = 0;
        for (String g : genreList) {
            int c = 0;
            for (Song s : eachMap.get(g)) {
                if (c > 1) {
                    break;
                }
                answer[i++] = s.index;
                c++;
            }
        }

        return answer;
    }
    
    static class Song {
        int index;
        int plays;
        
        public Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
    
    private Integer getTotalPlays(List<Song> songList) {
        int sum = 0;
        for (Song s : songList) {
            sum += s.plays;
        }
        return sum;
    }
}