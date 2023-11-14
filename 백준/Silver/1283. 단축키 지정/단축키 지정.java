import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String[] st;
    static String[] options;
    static Map<String, String> shortcuts = new HashMap<>();
    static Map<String, Integer> positions = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        options = new String[n];
        for (int i = 0; i < n; i++) {
            options[i] = br.readLine();
        }

        for (String option : options) {
            st = option.split(" ");

            int index = 0;
            for (String word : st) {
                String s = word.substring(0, 1).toUpperCase();
//                String s = String.valueOf(word.charAt(0));
                if (shortcuts.containsKey(s)) {
                    index += word.length() + 1;
                    continue;
                }
                shortcuts.put(s, option);
                positions.put(option, index);
                break;
            }

            if (positions.containsKey(option)) {
                continue;
            }

            index = 0;
            for (String word : st) {
                for (int i = 1; i < word.length(); i++) {
                    String s = word.substring(i, i + 1).toUpperCase();
                    if (shortcuts.containsKey(s)) {
                        continue;
                    }
                    shortcuts.put(s, option);
                    positions.put(option, index + i);
                    break;
                }
                if (positions.containsKey(option)) {
                    break;
                }
                index += word.length() + 1;
            }

            if (!positions.containsKey(option)) {
                shortcuts.put(" ", option);
                positions.put(option, -1);
            }
        }

        for (String option : options) {
            int idx = positions.get(option);
            for (int i = 0; i < option.length(); i++) {
                char c = option.charAt(i);
                if (i != idx) {
                    sb.append(c);
                } else {
                    sb.append('[').append(c).append(']');
                }
            }
            sb.append('\n');
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}