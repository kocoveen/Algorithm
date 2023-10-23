import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        System.out.println(convert(expr));
    }

    static String convert(String exp) { // 중위표기식을 후위표기식으로 변경하는 함수
        StringBuilder sb = new StringBuilder(); // 후위표기식
        Stack<Character> s = new Stack<>(); // (피연산자가 아닌) 기호를 넣을 식
        char c, t; // c는 수식에서 읽을 문자, t는 스택에서 pop된 문자
        int n = exp.length(); // 수식문 길이

        for (int i = 0; i < n; i++) {
            c = exp.charAt(i);
            switch (c) {
                /* 
                if (연산자) {
                    while (스택이 비지 않음 && c의 우선 순위 >= 스택 맨 위 항목의 우선순위) {
                        후위표기식에 pop한 것 붙임, 즉 c보다 작거나 같은 우선순위의 항목을 sb에 추가
                    }
                    마지막으로 c를 스택에 넣음
                }
                */
                case '+': case '-': case '*': case '/':
                    while (!s.isEmpty() && prec(c) >= prec(s.peek())) {
                        sb.append(s.pop());
                    }
                    s.push(c);
                    break;

                case '(':
                    s.push(c);
                    break;

                case ')':
                /* 
                t = 스택에서 꺼낸 값
                while (t가 '(' 아니라면) {
                    후위표기식에 t 붙임
                    t = 스택에서 꺼낸 값
                }
                */
                    t = s.pop();
                    while (t != '(') {
                        sb.append(t);
                        t = s.pop();
                    }
                    break;

                default:
                    sb.append(c);
                    break;
            }
        }

        /*
        스택이 빌 때까지 sb에 붙임
         */
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    static int prec(char op) { // 연산자 우선순위를 리턴하는 함수
        switch (op) {
            case '(': case ')':
                return 2;
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 0;
        }
        return 3;
    }
}