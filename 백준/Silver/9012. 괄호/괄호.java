import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
        
    int T = Integer.parseInt(reader.readLine());
    
    while (T-- > 0) {
      Deque<Character> deque = new ArrayDeque<>();
      String string = reader.readLine();
      boolean isVPS = true;
      for (char c : string.toCharArray()) {
        if (c == '(') {
          deque.push(c);
        } else if (c == ')') {
          if (deque.peek() == null) {
            isVPS = false;
            break;
          } else {
            deque.pop();
          }
        }
      }
          
      if (!deque.isEmpty()) {
        isVPS = false;
      }
          
      if (isVPS) {
          System.out.println("YES");
      } else {
          System.out.println("NO");
      }
    }
  }
}