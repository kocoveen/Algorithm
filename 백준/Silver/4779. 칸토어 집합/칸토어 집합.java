import java.io.*;

public class Main {
    static int size;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l;
        while ((l = br.readLine()) != null) {
            int N = Integer.parseInt(l);
            sb = new StringBuilder();
            size = (int) Math.pow(3, N);
            sb.append("-".repeat(size));
            Cantor(sb, 0, size);
            System.out.println(sb);
        }
    }

    private static void Cantor(StringBuilder sb, int start, int size) {
        if (size == 1) return;
        
        int leftPoint = start + size / 3;
        int rightPoint = start + size / 3 * 2;
        size /= 3;

        sb.replace(leftPoint, rightPoint, " ".repeat(size));
        
        Cantor(sb, start, size);
        Cantor(sb, rightPoint, size);
    }
}