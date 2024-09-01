import java.util.Scanner;

public class Main {
  static String[] strings;
  static int start = -1;
  
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    strings = new String[3];
    
    strings[0] = sc.next();
    strings[1] = sc.next();
    strings[2] = sc.next();
    
    Loop:
    for (int i = 0; i < 3; i++) {
      for (char c : strings[i].toCharArray()) {
        if ('0' <= c && c <= '9') {
          start = Integer.valueOf(strings[i]) + 3 - i;
          break Loop;
        }
      }
    }
    
    if (start % 3 == 0 && start % 5 == 0) System.out.println("FizzBuzz");
    else if (start % 3 == 0) System.out.println("Fizz");
    else if (start % 5 == 0) System.out.println("Buzz");
    else System.out.println(start);

  }
}