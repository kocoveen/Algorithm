import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.next().toCharArray();


        System.out.println(getMax(str));
        System.out.println(getMin(str));
    }

    private static String getMax(char[] str) {
        StringBuilder val = new StringBuilder();
        int len = 0;
        for (char c : str) {
            len++;
            if (c == 'K') {
                val.append(getNumber(len, 5));
                len = 0;
            }
        }
        
        if (len > 0) {
            val.append("1".repeat(len));
        }
        return val.toString();
    }

    private static String getMin(char[] str) {
        StringBuilder val = new StringBuilder();
        int len = 0;
        for (int i = 0; i < str.length - 1; i++) {
            len++;
            if (str[i] == 'M') { 
                if (str[i+1] == 'K') {
                    val.append(getNumber(len, 1));
                    len = 0;
                }
            } else {
                val.append(5);
                len = 0;
            }
        }

        len++;
        if (str[str.length - 1] == 'M') {
            val.append(getNumber(len, 1));
        } else {
            val.append(5);
        }
        return val.toString();
    }

    private static String getNumber(int len, int s) {
        StringBuilder number = new StringBuilder();
        number.append(s);
        while (len-- > 1) {
            number.append(0);
        }
        return number.toString();
    }
}