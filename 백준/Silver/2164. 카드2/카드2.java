import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    int n = read();
    
    Deque<Integer> dq = new ArrayDeque<>();
    while (n > 0) {
      dq.addFirst(n--);
    }
    
    while (dq.size() > 1) {
      dq.removeFirst();
      dq.addLast(dq.removeFirst());
    }
    
    System.out.println(dq.removeFirst());
  }
  
  private static int read() throws Exception {
    int c, n = System.in.read() & 15;
    while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
    return n;
  }
}