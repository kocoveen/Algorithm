import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] inputChar = input.toCharArray();

        for (int i = 0; i < inputChar.length; i++) {
            if (Character.isUpperCase(inputChar[i])) {
                inputChar[i] = Character.toLowerCase(inputChar[i]);
            } else {
                inputChar[i] = Character.toUpperCase(inputChar[i]);
            }
        }

        for (char c : inputChar) {
            System.out.printf("%c", c);
        }
    }
}