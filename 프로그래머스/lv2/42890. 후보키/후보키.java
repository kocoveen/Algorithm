import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    String[][] table;
    int row, col;
    List<Set<Character>> candidateKeys;

    public int solution(String[][] relation) {
        table = relation;
        row = table.length;
        col = table[0].length;
        candidateKeys = new ArrayList<>();

        String columns = "";
        for(int i = 0; i < col; i++) {
            columns += i;
        }

        for(int i = 1; i < col + 1; i++) {
            combination(columns, new HashSet<>(), i);
        }

        return candidateKeys.size();
    }

    void combination(String columns, Set<Character> out, int r) {
        if(r == 0) {
            if (isUnique(out) && isMinimal(out))
                candidateKeys.add(out);
            return;
        }

        for(int i = 0; i < columns.length(); i++) {
            Set<Character> newOut = new HashSet<>(out);
            newOut.add(columns.charAt(i));
            combination(columns.substring(i + 1), newOut, r - 1);
        }
    }

    boolean isUnique(Set<Character> key) {
        Set<String> set = new HashSet<>();
        for (String[] row : table) {
            String projection = "";
            for (char col : key) {
                projection += row[col - '0'];
            }
            if (set.contains(projection)) return false;
            else set.add(projection);
        }
        return true;
    }

    boolean isMinimal(Set<Character> key) {
        for (Set<Character> candidateKey: candidateKeys) {
            if (key.containsAll(candidateKey)) return false;
        }
        return true;
    }
}