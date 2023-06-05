import java.io.*;

public class Main {
    static String[] l;

    static int psum, msum;

    static String[] operands;
    static String[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l = br.readLine();
        operands = l.split("\\D");
        operators = l.split("\\d+");

        int i = 1;
        while (operators.length > i && !operators[i].equals("-")) i++;

        for (int j = 0; j < i; j++)
            psum += Integer.parseInt(operands[j]);

        for (int j = i; j < operands.length; j++)
            msum += Integer.parseInt(operands[j]);

        System.out.println(psum - msum);
    }

    private static void print(String[] arr) {
        for (String s : arr) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}