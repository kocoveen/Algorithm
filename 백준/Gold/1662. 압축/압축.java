import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> s = new ArrayDeque<>();
        String str = sc.next(); // 압축된 문자열

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                s.push(1);
            } else if (c == '(') {
                s.poll(); // 마커(-1) 제거
                s.push(str.charAt(i-1) - '0');
                s.push(-1);
            } else {
                int len = 0;
                while (!s.isEmpty() && s.peek() != -1) {
                    len += s.poll();
                }
                s.poll(); // '(' 마커(-1) 제거
                int K = s.poll(); // 반복 횟수 K
                s.push(len * K); // 압축 해제된 길이만 스택에 다시 삽입
            }
        }

        int answer = 0;
        while (!s.isEmpty()) {
            answer += s.poll();
        }
        System.out.println(answer);
    }
}