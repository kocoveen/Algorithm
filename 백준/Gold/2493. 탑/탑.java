import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(reader.readLine());
    String[] line = reader.readLine().split(" ");
    
    int[] tops = new int[N];
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = -1;
    }
    
    for (int i = 0; i < N; i++) {
      tops[i] = Integer.parseInt(line[i]);
    }
    
    Deque<Tuple> dq = new ArrayDeque<>();
    
    for (int i = 0; i < N; i++) {
      while (!dq.isEmpty() && dq.getLast().val <= tops[i]) {
        Tuple t = dq.removeLast();
        nums[t.idx] = dq.isEmpty() ? 0 : dq.getLast().idx + 1;
      }
      dq.addLast(new Tuple(i, tops[i]));
    }
    
    while (!dq.isEmpty()) {
      Tuple t = dq.removeLast();
      nums[t.idx] = dq.isEmpty() ? 0 : dq.getLast().idx + 1;
    }
    
    
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }
  
  static class Tuple {
    int idx, val;
    
    Tuple(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }
}