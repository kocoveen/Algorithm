import java.util.*;
import java.util.regex.*;

class Solution {
    
    static Set<Integer> radixes = new HashSet<>();
    
    static int minRadix = 2, maxRadix = 9;
    static int radix = 0;
    
    public String[] solution(String[] expressions) {
        
        // 숫자로 가능성 있는 진법 중 낮은 진법(나온 숫자 중 최대 숫자 + 1)을 구함
        for (String expression : expressions) {
            char[] ch = expression.toCharArray();
            for (char c : ch) {
                if ('1' <= c && c <= '8') {
                    minRadix = Math.max(minRadix, c - '0' + 1);
                }
            }
        }
        
        // System.out.println(minRadix);
        
        // 2. 계산식에서 범위를 좁힘.
        TreeSet<Integer> S = new TreeSet<>();
        for (int i = minRadix; i <= maxRadix; i++) { S.add(i); }
        for (String expression : expressions) {
            String[] str = expression.split(" ");
            
            if (str[4].equals("X")) { continue; }
            
            // 최소 진법부터 최대까지 맞는 진법 확인
            TreeSet<Integer> s = new TreeSet<>();
            for (int r = minRadix; r <= maxRadix; r++) {
                if (isCorrectExpr(str, r)) {
                    s.add(r);
                }
            }
            S.retainAll(s);
        }
        
        // System.out.println(S);
        
        // 3. X에 값 채워 넣기
        List<String> answer = new ArrayList<>();
        for (String expression : expressions) {
            if (!expression.contains("X")) { continue; }
            
            TreeSet<String> ansSet = new TreeSet<>();
            for (int r : S) {
                ansSet.add(getAns(expression, r));
            }
            
            if (ansSet.size() > 1) {
                answer.add(expression.replaceAll("X", "?"));
            } else {
                answer.add(expression.replaceAll("X", ansSet.first()));
            }

        }        
        return answer.toArray(new String[answer.size()]);
    }
    
    private String getAns(String expr, int r) {
        String[] str = expr.split(" ");
        
        int a = Integer.parseInt(str[0], r);
        String o = str[1];
        int b = Integer.parseInt(str[2], r);
        
        switch (o) {
            case "+": {
                return Integer.toString(a + b, r);
            }
            case "-": {
                return Integer.toString(a - b, r);
            }
        }
        return "";
    }
    
    private boolean isCorrectExpr(String[] str, int r) {
        int a = Integer.parseInt(str[0], r);
        String o = str[1];
        int b = Integer.parseInt(str[2], r);
        int c = Integer.parseInt(str[4], r);
        
        switch (o) {
            case "+": {
                // System.out.printf("[%s, %s, %s](%d) %b\n", a, b, c, r, (a + b) == c);
                return (a + b) == c;
            }
            case "-": {
                // System.out.printf("[%s, %s, %s](%d) %b\n", a, b, c, r, (a - b) == c);
                return (a - b) == c;
            }
        }
        
        return false;
    }
}