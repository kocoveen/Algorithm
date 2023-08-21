import java.util.*;

class Solution {

    public int[] solution(String msg) {
        String[] strArr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            hashMap.put(strArr[i], i + 1);
        }
        // 재귀함수에 넣기
        LZW(hashMap, list, msg);

        int[] answer = new int[list.size()];
        int index = 0;
        for (int num : list) {
            answer[index] = num;
            index++;
        }

        return answer;
    }

    private void LZW(HashMap<String, Integer> hashMap, ArrayList<Integer> list, String str) {

        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(0, i + 1);
            if (!hashMap.containsKey(subStr)) {
                hashMap.put(subStr, hashMap.size() + 1);
                list.add(hashMap.get(str.substring(0, i)));
                LZW(hashMap, list, str.substring(i));
                break;
            } else {
                if (i + 1 == str.length()) {
                    list.add(hashMap.get(str.substring(0, i + 1)));
                }
            }
        }
    }
}