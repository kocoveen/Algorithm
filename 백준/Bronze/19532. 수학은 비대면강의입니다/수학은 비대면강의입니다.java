import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] mat = new int[2][3];
        int[] result = new int[2];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int d = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];

        int temp = mat[1][1];
        mat[1][1] = mat[0][0];
        mat[0][0] = temp;
        mat[0][1] = -mat[0][1];
        mat[1][0] = -mat[1][0];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i] += (mat[i][j] * mat[j][2]);
            }
            result[i] /= d;
        }

        bw.write(result[0] + " " + result[1]);

        bw.flush();
        br.close();
        bw.close();
    }
}