import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int N = Integer.parseInt(reader.readLine());
    
    Stack stack = new Stack(N);
    
    while(N-- > 0) {
      String[] line = reader.readLine().split(" ");
      switch (line[0]) {
        case "push": {
          int x = Integer.parseInt(line[1]);
          stack.push(x);
          break;
        }
        case "pop": {
          writer.write(String.valueOf(stack.pop()));
          writer.newLine();
          break;
        }
        case "size": {
          writer.write(String.valueOf(stack.size()));
          writer.newLine();
          break;
        }
        case "empty": {
          writer.write(String.valueOf(stack.empty()));
          writer.newLine();
          break;
        }
        case "top": { 
          writer.write(String.valueOf(stack.top()));
          writer.newLine();
          break;
        }
      }
    }
    writer.flush();
  }
  
  static class Stack {
    private int[] data;
    private int top;
    
    public Stack(int N) {
      this.data = new int[N];
      this.top = -1;
    }
    
    public void push(int x) {
      data[++top] = x;
    }
    
    public int pop() {
      return empty() == 1 ? -1 : data[top--];
    }
    
    public int size() {
      return top + 1;
    }
    
    public int empty() {
      return size() == 0 ? 1 : 0;
    }
    
    public int top() {
      return empty() == 1 ? -1 : data[top];
    }
  }
}