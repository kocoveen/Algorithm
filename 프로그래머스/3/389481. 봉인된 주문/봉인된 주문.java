import module java.base;

class Solution {
    public String solution(long n, String[] bans) {
        List<Long> banNums = new ArrayList<>();
        
        for (String ban : bans) {
            banNums.add(toNum(ban));
        }
        
        Collections.sort(banNums);
        
        long k = n;
        for (long num : banNums) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        
        return toSpell(k);
    }
    
    private long toNum(String spell) {
        long result = 0;
        long mul = 1;
        for (int i = spell.length() - 1; i >= 0; i--) {
            result += (spell.charAt(i) - 'a' + 1) * mul;
            mul *= 26;
        }
        return result;
    }
    
    private String toSpell(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--;
            int a = (int) (num % 26);
            sb.append((char) (a + 'a'));
            num /= 26;
        }
        return sb.reverse().toString();
    }
}