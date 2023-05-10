import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> rank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++)
            rank.put(players[i], i);
        
        for (int i = 0; i < callings.length; i++) {
            
            int score = rank.get(callings[i]);
            
            String temp = players[score];
            players[score] = players[score - 1];
            players[score - 1] = temp;
            
            rank.replace(callings[i], score - 1);
            rank.replace(players[score], rank.get(players[score]) + 1);
        }
        
        return players;
    }
}