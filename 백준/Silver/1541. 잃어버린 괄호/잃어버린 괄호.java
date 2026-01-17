import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String[] op;
    static String[] NumStr;
    static int[] Num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String formula = br.readLine();
        NumStr = formula.split("\\D");
        op = formula.split("\\d+");
        Num = new int[NumStr.length];

        for (int i = 0; i < Num.length; i++)
            Num[i] = Integer.parseInt(NumStr[i]);

        int sum = Num[0]; int i = 1;
        while (i < Num.length && op[i].equals("+")) {
            sum += Num[i];
            i++;
        }

        int tmp = 0;
        for (int j = i; j < Num.length; j++)
            tmp += Num[j];

        System.out.println(sum - tmp);
    }
}