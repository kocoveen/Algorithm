import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        int cursor = k;
        
        Deque<Integer> deleted = new ArrayDeque<>();
        
        for (String cmd : cmds) {
            String[] str = cmd.split(" ");
            
            switch (str[0]) {
                case "D": {
                    cursor += Integer.parseInt(str[1]);
                    if (cursor == n - deleted.size()) { cursor--; }
                    break;
                }
                    
                case "U": {
                    cursor -= Integer.parseInt(str[1]);
                    if (cursor == -1) { cursor++; }
                    break;
                }
                    
                case "C": {
                    deleted.push(cursor);
                    if (cursor == n - deleted.size()) { cursor--; }
                    break;
                }
                    
                case "Z": {
                    int replaced = deleted.pop();
                    if (cursor >= replaced) { cursor++; }
                    break;
                }
            }
        }
        
        
        String str = "O".repeat(n - deleted.size());
        StringBuilder sb = new StringBuilder(str);
        while (!deleted.isEmpty()) {
            int index = deleted.pop();
            sb.insert(index, "X");
        }
        
        return sb.toString();
    }
}