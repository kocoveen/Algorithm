import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        int[] nums = new int[26];

        for (int i = 0; i < n; i++) words[i] = br.readLine();

        for (String word : words) {
            int digit = (int) Math.pow(10, word.length() - 1);
            for (int i = 0; i < word.length(); i++) {
                nums[word.charAt(i) - 'A'] += digit;
                digit /= 10;
            }
        }

        Arrays.sort(nums);
        int sum = 0;
        int num = 9;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 0) break;
            sum += num-- * nums[i];
        }
        System.out.println(sum);
    }
}