class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for (int i = 0; i < dic.length; i++) {
            for (String chr: spell) {
                if (dic[i].contains(chr)){
                    dic[i] = dic[i].replaceFirst(chr, "");
                } else {
                    dic[i] = dic[i] + chr;
                }
                
            }
                System.out.println(dic[i]);
        }
        
        
        for (String word: dic) {
            if (word.equals("")) {
                answer = 1;
            }
        }

        return answer;
    }
}