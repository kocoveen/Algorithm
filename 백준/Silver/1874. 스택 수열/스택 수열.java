import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    
    StringBuilder sb = new StringBuilder();
    
    int n = Integer.parseInt(reader.readLine());

    Deque<Integer> stack= new ArrayDeque<>(); // 입력된 수열을 만들 스택
    
    int k = 1;
    
    for (int i = 0; i < n; i++) {
      int target = Integer.parseInt(reader.readLine());
      while (k <= target) {
          stack.addLast(k++);
          sb.append("+\n");
      }

      if (!stack.isEmpty() && stack.getLast() == target) {
          stack.removeLast();
          sb.append("-\n");
      } else {
          System.out.println("NO");
          return;
      }
    }
    System.out.println(sb);
  }
}