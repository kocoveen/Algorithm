import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    String[] string = reader.readLine().split(" ");
        
    int N = Integer.parseInt(string[0]);
    int K = Integer.parseInt(string[1]);
    
    Deque<Integer> dq = new ArrayDeque<>();
    
    for (int i = 1; i <= N; i++) {
      dq.push(i);
    }
    
    writer.write("<");
    while (!dq.isEmpty()) {
      for (int i = 0; i < K-1; i++) {
        dq.addFirst(dq.removeLast());
      }
      writer.write(String.valueOf(dq.removeLast()));
      if (!dq.isEmpty()) {
        writer.write(", ");
      }
    }
    writer.write(">");
    writer.flush();
  }
}