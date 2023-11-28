import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {

        int cursor = k;
        Deque<Integer> deleted = new ArrayDeque<>();

        for (String cmd : cmds) {
            String[] st = cmd.split(" ");

            switch (st[0]) {
                case "D": {
                    cursor += Integer.parseInt(st[1]);
                    break;
                }
                case "U": {
                    cursor -= Integer.parseInt(st[1]);
                    break;
                }
                case "C": {
                    deleted.push(cursor);
                    if (cursor == n - deleted.size()) {
                        cursor--;
                    }
                    break;
                }
                case "Z": {
                    int restore = deleted.pop();
                    if (restore <= cursor) {
                        cursor++;
                    }
                    break;
                }
            }
        }

        String answer = "O".repeat(n - deleted.size());
        StringBuilder sb = new StringBuilder(answer);
        while (!deleted.isEmpty()) {
            sb.insert(deleted.pop(), "X");
        }
        return sb.toString();
    }
}