import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, (s1, s2) -> {
            Matcher m1 = pattern.matcher(s1.toLowerCase());
            Matcher m2 = pattern.matcher(s2.toLowerCase());
            m1.find();
            m2.find();

            if(!m1.group(1).equals(m2.group(1))) {
                return m1.group(1).compareTo(m2.group(1));
            }
            return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
        });

        return files;
    }
}
