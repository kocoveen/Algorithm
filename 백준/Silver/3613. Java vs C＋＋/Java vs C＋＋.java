import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vName = br.readLine();

        if (isExceptionable(vName)) {
            bw.write("Error!");
        } else {
            if (isCamelCase(vName)) {
                bw.write(toSnakeCase(vName));
            } else {
                bw.write(toCamelCase(vName));
            }
        }
        bw.close();
    }

    private static boolean isExceptionable(String vName) {
        int c1 = 0, c2 = 0;
        for (int i = 0; i < vName.length(); i++) {
            if (vName.charAt(i) == '_') {
                c1++;
            }
            if (Character.isUpperCase(vName.charAt(i))) {
                c2++;
            }
        }

        if (c1 > 0 && c2 > 0) {
            return true;
        }

        return vName.startsWith("_") ||
                vName.endsWith("_") ||
                vName.contains("__") ||
                Character.isUpperCase(vName.charAt(0));
    }

    private static String toSnakeCase(String vName) {
        StringBuilder sb = new StringBuilder(vName);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.replace(i, i+1, "_" + Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    private static String toCamelCase(String vName) {
        StringBuilder sb = new StringBuilder(vName);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '_') {
                sb.deleteCharAt(i);
                c = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(i, Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    private static boolean isCamelCase(String vName) {
        for (int i = 0; i < vName.length(); i++) {
            if (!Character.isLowerCase(vName.charAt(i)) && !Character.isUpperCase(vName.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}