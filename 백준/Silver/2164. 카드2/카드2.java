import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> deck = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            deck.add(i);

        while (deck.size() != 1) {
            deck.remove();
            deck.add(deck.remove());
        }

        System.out.println(deck.remove());

    }
}