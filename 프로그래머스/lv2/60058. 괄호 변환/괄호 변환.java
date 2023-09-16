import java.lang.StringBuilder;

class Solution {
    public String solution(String p) {
        StringBuilder brackets = new StringBuilder(p);
        return func(brackets).toString();
    }

    public StringBuilder func(StringBuilder brackets) {
        if (isCorrect(brackets)) {
            return brackets;
        }

        StringBuilder origin = new StringBuilder();
        StringBuilder[] bits = separate(brackets);

        if (isCorrect(bits[0])) {
            return origin.append(func(bits[0])).append(func(bits[1]));
        } else {
            origin.append('(');
            origin.append(func(bits[1]));
            origin.append(')');
            origin.append(func(convert(bits[0])));
        }

        return origin;
    }

    private StringBuilder convert(StringBuilder bit) {
        if (bit.length() == 0) {
            return bit;
        }
        return opposite(bit.deleteCharAt(bit.length() - 1).deleteCharAt(0));
    }

    private StringBuilder opposite(StringBuilder bit) {
        for (int i = 0; i < bit.length(); i++) {
            if (bit.charAt(i) == '(') {
                bit.replace(i, i + 1, ")");
            } else {
                bit.replace(i, i + 1, "(");
            }
        }
        return bit;
    }

    private boolean isCorrect(StringBuilder brackets) {
        int count = 0;
        int idx = 0;

        while (idx < brackets.length()) {
            if (brackets.charAt(idx) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == -1) {
                return false;
            }
            idx++;
        }
        return true;
    }

    private StringBuilder[] separate(StringBuilder brackets) {

        int count = 0;
        int idx = 0;
        StringBuilder[] builders = new StringBuilder[2];

        while (idx < brackets.length()) {
            if (brackets.charAt(idx) == '(') {
                count++;
            } else {
                count--;
            }

            idx++;
            if (count == 0) {
                break;
            }
        }

        builders[0] = new StringBuilder(brackets.substring(0, idx));
        builders[1] = new StringBuilder(brackets.substring(idx, brackets.length()));

        return builders;
    }
}