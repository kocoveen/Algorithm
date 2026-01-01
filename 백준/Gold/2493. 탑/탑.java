import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(reader.readLine());
    String[] line = reader.readLine().split(" ");
    
    Deque<Tuple> dq = new ArrayDeque<>();
    dq.addLast(new Tuple(0, 100000001));
    
    for (int i = 1; i <= N; i++) {
      int h = Integer.parseInt(line[i-1]);
      while (dq.getLast().val < h) { dq.removeLast(); }
      writer.write(dq.getLast().idx + " ");
      dq.addLast(new Tuple(i, h));
    }
    writer.flush();
  }
  
  static class Tuple {
    int idx, val;
    
    Tuple(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }
}