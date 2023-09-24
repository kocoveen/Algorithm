import java.util.*;

class Solution {
    List<List<Token>> L = new ArrayList<>();

    public int solution(String s) {
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            L.add(new ArrayList<>());
        }
        L.get(0).add(new Token(s, 1));

        for (int unit = 1; unit < s.length(); unit++) {
            List<Token> tokens = L.get(unit);
            int idx;
            for (idx = 0; idx + unit <= s.length(); idx += unit) {
                String split = s.substring(idx, idx + unit);

                if (tokens.isEmpty()) {
                    tokens.add(new Token(split));
                    continue;
                }

                Token lastToken = tokens.get(tokens.size() - 1);
                if (lastToken.str.equals(split)) {
                    lastToken.addCount(1);
                    continue;
                }

                tokens.add(new Token(split));
            }

            if (idx < s.length()) {
                tokens.add(new Token(s.substring(idx)));
            }
        }

         for (int i = 0; i < L.size(); i++) {
//             System.out.print(i + " : ");

             StringBuilder sb = new StringBuilder();
             for (Token t : L.get(i)) {
                if (t.count == 1) {
                    sb.append(t.str);
                } else {
                    sb.append(t.count).append(t.str);
                }
             }

             if (minLength > sb.length()) {
                 minLength = sb.length();
             }

//             System.out.println(sb);
//             for (Token t : L.get(i)) {
//                 System.out.println("\t-" + t.str + " : " + t.count);
//             }
         }

        return minLength;
    }

    static class Token {
        String str;
        int count = 1;

        public Token() {}

        public Token(String str) {
            this.str = str;
        }

        public Token(String str, int count) {
            this(str);
            this.count = count;
        }

        public void addCount(int i) {
            this.count += i;
        }
    }
}