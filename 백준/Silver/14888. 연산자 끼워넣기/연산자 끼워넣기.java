import java.io.*;

public class Main {
    static String[] l;

    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    static int[] num;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(l[i]);

        operator = new int[4];
        l = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(l[i]);

        func(0, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void func(int depth, int value) {
        if (depth == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            func(depth + 1, calculate(value, num[depth + 1], i));
            operator[i]++;
        }
    }

    private static int calculate(int op1, int op2, int operand) {
        if (operand == 0)
            return op1 + op2;
        else if (operand == 1)
            return op1 - op2;
        else if (operand == 2)
            return op1 * op2;
        else return op1 / op2;
    }
}