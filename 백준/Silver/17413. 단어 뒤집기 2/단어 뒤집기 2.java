import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static char[] line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        boolean inTag = false;
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '<') {
                // 이전단어 뒤집기
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(line[i]);

            } else if (line[i] == '>') {
                inTag = false;
                sb.append(line[i]);

            } else if (inTag) {
                // 태그 안은 추가
                sb.append(line[i]);

            } else if (line[i] == ' ') {
                // 공백 전의 단어 뒤집기
                while (!stack.isEmpty()) { 
                    sb.append(stack.pop());
                }
                sb.append(line[i]);

            } else {
                // 뒤집을 단어 쌓기
                stack.push(line[i]);
            }
        }

        while (!stack.isEmpty()) { 
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}