import java.util.Arrays;
import java.util.stream.LongStream;

class Solution {
    public int[] solution(int n, long left, long right) {
        return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
    }
}