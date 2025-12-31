import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(reader.readLine());
    String[] line = reader.readLine().split(" ");
    
    Deque<Tuple> dq = new ArrayDeque<>();
    
    for (int i = 1; i <= N; i++) {
      int num = Integer.parseInt(line[i-1]);
      dq.addLast(new Tuple(i, num));
    }
    
    
    while (!dq.isEmpty()) {
      Tuple t = dq.removeFirst();
      writer.write(t.index + "\s");
      if (dq.isEmpty()) break;
      if (t.value >= 0) {
        for (int i = 0; i < t.value-1; i++) {
          dq.addLast(dq.removeFirst());
        }
      } else {
        for (int i = 0; i < -t.value; i++) {
          dq.addFirst(dq.removeLast());
        }
      }
    }
    writer.flush();
  }
  
  static class Tuple {
    private int index, value;
    
    Tuple(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}