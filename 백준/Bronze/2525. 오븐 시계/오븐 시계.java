import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(); int M = sc.nextInt(); int add = sc.nextInt();
        int t = ((H * 60 + M) + add + 1440) % 1440;
        int rH = t / 60;
        int rM = t - (rH * 60);
        System.out.printf("%d %d", rH, rM);
    }
}