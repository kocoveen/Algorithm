import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int room = 0;
        while(n > 0) {
            if (room == 0)
                n -= 1;
            n -= room * 6;
            room++;
        }
        System.out.println(room);
    }
}