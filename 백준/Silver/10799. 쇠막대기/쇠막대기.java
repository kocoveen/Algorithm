import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));

    Deque<Character> stack = new ArrayDeque<>();
    
    String input = reader.readLine();
    
    int count = 0;
    char prev = '=';
    for (char c : input.toCharArray()) {
      if (c == '(') {
        stack.addLast(c);
      } else {
        stack.removeLast();
        if (prev == '(') {
          count += stack.size();
        } else {
          count++;
        }
      }
      prev = c;
    }
    System.out.println(count);
  }
}