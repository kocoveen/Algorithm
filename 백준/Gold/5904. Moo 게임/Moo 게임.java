import java.util.Scanner;

public class Main {

    static int k;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        arr = new int[30];
        arr[0] = 0;
        arr[1] = 3;

        for (int i = 1; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i] * 2 + i + 3;
        }

        int index = 30;
        int prevLen = arr[index - 1];
        System.out.println(func(k, index, 1, 1 + prevLen, 1 + prevLen + index + 2));

    }

    static String func(int n, int index, int l_st, int m_st, int r_st) {

        if (index == 0) {
            return getMoo(n, m_st);
        }

        String result;
        int prevLen = arr[index - 1];

        if (n < m_st) {
            result = func(n, index - 1, l_st, l_st + prevLen, l_st + prevLen + index + 2);
        } else if (n < r_st) {
            return getMoo(n, m_st);
        } else {
            result = func(n, index - 1, r_st, r_st + prevLen, r_st + prevLen + index + 2);
        }
        return result;


    }

    static String getMoo(int n, int m_st) {
        if (n == m_st) return "m";
        return "o";
    }
}