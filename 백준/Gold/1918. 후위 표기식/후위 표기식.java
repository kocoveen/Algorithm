import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    char[] infix = reader.readLine().toCharArray(); // 중위표기식
    
    Deque<Character> stack = new ArrayDeque<>(); // 스택
    
    for (char c : infix) {
      // 피연산자이면 그대로 출력
      if ('A' <= c && c <='Z') {
        writer.write(c);
        continue;
      }
      
      // 연산자 or 괄호일 때, 비었으면 push
      if (stack.isEmpty()) {
        stack.addLast(c);
        continue;
      }
      
      // 연산자가 스택의 top보다 우선순위가 높으면 push
      // 연산자가 스택의 top보다 우선순위가 낮거나 같다면 pop하여 출력, 현재 연산자는 push
      // 여는 괄호 => push
      // 닫는 괄호 => 여는 괄호가 나올 때까지 pop, 여는 괄호는 버림.
      switch (c) {
        case '+': 
        case '-': {
          while (!stack.isEmpty() && stack.getLast() != '(') {
            char pop = stack.removeLast();
            writer.write(pop);
          }
          stack.addLast(c); 
          break;
        }
        
        case '*': 
        case '/': {
          while (!stack.isEmpty() && (stack.getLast() == '*' || stack.getLast() == '/')) {
            char pop = stack.removeLast();
            writer.write(pop);
          }
          stack.addLast(c);
          break;
        }
        
        case '(': {
          stack.addLast(c);
          break;
        }
        
        case ')': {
          while (stack.getLast() != '(') {
            char pop = stack.removeLast();
            writer.write(pop);
          }
          stack.removeLast();
          break;
        }
      }
    }

    // 더 이상 스캔할 입력 리스트 값이 없다면, 하나씩 pop하여 출력
    while (!stack.isEmpty()) {
      char pop = stack.removeLast();
      writer.write(pop);        
    }
    writer.flush();
  }
}