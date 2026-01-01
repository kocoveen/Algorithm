import java.io.*;
import java.util.*;

public class Main {
  static char[] expression; // 수식
  static Map<Integer, int[]> map = new HashMap<>(); // <괄호의 id : 괄호쌍의 위치>
  static int idx = 0; // 괄호쌍 id;
  static TreeSet<String> expression1 = new TreeSet<>(); // 괄호 쌍 제거 수식
  
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    
    expression = reader.readLine().toCharArray();
    
    Deque<Integer> dq = new ArrayDeque<>(); // 여는 괄호의 위치만 저장
    // 순회하면서, 괄호 위치 저장
    for (int i = 0; i < expression.length; i++) {
      if (expression[i] == '(') {
        dq.addLast(i);
      } else if (expression[i] == ')') {
        map.put(idx++, new int[]{dq.removeLast(), i});
      }
    }
    
    // 조합을 만들기 위한 순회.
    for (int i = 0; i < idx; i++) {
      func(0, 0, i+1);
    }
    
    for (String exp : expression1) {
      System.out.println(exp);
    }
  }

  // 조합을 위한 메서드
  static void func(int s, int d, int e) {
    if (d == e) {
      expression1.add(String.valueOf(expression).replace("\0", ""));
      return;
    }
    
    for (int i = s; i < idx; i++) {
      int[] pos = map.get(i);

      expression[pos[0]] = '\0';
      expression[pos[1]] = '\0';
      func(i+1, d+1, e);
      expression[pos[0]] = '(';
      expression[pos[1]] = ')';
    }
  }
}