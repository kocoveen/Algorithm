import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    String input = reader.readLine();
    Deque<Character> stack = new ArrayDeque<>();
    
    int value = 0; int tmp = 1;
    char prev = 0;
    for (char c : input.toCharArray()) {
      if (c == '(' || c == '[') { // 여는 괄호면,
        tmp *= (c == '(' ? 2 : 3);
        stack.addLast(c);
      } else {                    // 닫는 괄호면,
        char open = (c == ')' ? '(' : '[');
        int div = (c == ')' ? 2 : 3);
        
        if (stack.isEmpty() || stack.getLast() != open) {
          System.out.println(0);
          return;
        }
        
        // 전 괄호가 여는 괄호면, 계산된 깊이의 괄호값을 더함.
        if (prev == open) {
          value += tmp;
        }
        
        stack.removeLast();
        tmp /= div; // 깊이가 낮아졌기 때문에, 곱한 값의 깊이를 줄임.
      }
      prev = c; // 전의 값 저장.
    }
    
    if (stack.isEmpty()) {
      System.out.println(value);
    } else {
      System.out.println(0);
    }
  }
}