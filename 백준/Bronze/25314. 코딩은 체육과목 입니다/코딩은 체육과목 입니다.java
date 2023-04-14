import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        for (int i = 4; i <= X; i+=4)
            System.out.print("long ");
        System.out.print("int");
    }
}