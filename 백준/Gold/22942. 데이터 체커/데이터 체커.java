import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(reader.readLine());
    List<Point> points = new ArrayList<>();
    
    while (N-- > 0) {
      String[] line = reader.readLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int r = Integer.parseInt(line[1]);
      points.add(new Point(N, x - r, State.LEFT));
      points.add(new Point(N, x + r, State.RIGHT));
    }
    
    // x 값으로 오름차순 정렬
    Collections.sort(points, (p1, p2) -> p1.val - p2.val); 
    
    Deque<Point> dq = new ArrayDeque<>();
    
    // 정렬된 점을 순회해, 올바른 괄호 맞추기처럼 풀기
    for (Point b : points) {
      if (dq.isEmpty()) {
        if (b.state == State.RIGHT) {
          System.out.println("NO");
          return;
        }
        dq.addLast(b);
        continue;
      }
    
    
      // 원의 왼쪽 점일 때
      if (b.state == State.LEFT) {
        dq.addLast(b);
        continue;
      }
      
      // 원의 오른쪽 점이고, 스택 탑의 점과 같은 원의 점일 때
      Point p = dq.getLast();
      if (b.idx == p.idx) {
        dq.removeLast();
      }
    }
    
    if (dq.isEmpty()) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
  
  static class Point {
    int idx;
    int val;
    State state;
    
    public Point(int idx, int val, State state) {
      this.state = state;
      this.val = val;
      this.idx = idx;
    }
  }

  static enum State {
    LEFT, RIGHT
  }
}