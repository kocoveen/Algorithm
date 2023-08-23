import java.util.*;

class Solution {
    
    static final String[] ACTION = {"님이 들어왔습니다.", "님이 나갔습니다."};
    
    public String[] solution(String[] record) {
        
        Map<String, String> idToNickMap = new HashMap<>();
        List<String[]> chatLog = new ArrayList();
        
        for (String r : record) {
            String[] l = r.split(" ");
            String command = l[0];
            String id = l[1];
            String nickname = null;
            
            String action = null;
            
            switch(command) {
                case "Enter": {
                    nickname = l[2];
                    idToNickMap.put(id, nickname);
                    chatLog.add(new String[]{id, ACTION[0]});
                    break;
                }
                case "Leave": {
                    chatLog.add(new String[]{id, ACTION[1]});
                    break;
                }
                case "Change": {
                    nickname = l[2];
                    idToNickMap.put(id, nickname);
                    break;
                }
            }
        }
        
        List<String> parsedChatLog = parseNickname(idToNickMap, chatLog);
        
        return parsedChatLog.toArray(new String[parsedChatLog.size()]);
    }
    
    private List<String> parseNickname(Map<String, String> idToNickMap, List<String[]> chatLog) {
        List<String> parsedChatLog = new ArrayList<>();
        for (String[] c : chatLog) {
            parsedChatLog.add(idToNickMap.get(c[0]) + c[1]);
        }
        return parsedChatLog;
    }
}