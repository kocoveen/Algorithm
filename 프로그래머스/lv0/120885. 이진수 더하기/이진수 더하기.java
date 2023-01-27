class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        int dec1 = 0;
        int dec2 = 0;
        
        dec1 = binToDec(bin1);
        dec2 = binToDec(bin2);      
        answer = decToBin(dec1+dec2);
        
        return answer;
    }
    
    public int binToDec(String bin) {
        int dec = 0;
        int mult = 1;
        for (int i = bin.length()-1; i >= 0; i--) {
            dec += (bin.charAt(i) == '1' ? mult : 0);
            mult *= 2;
        }
        return dec;
    }
    
    public String decToBin(int dec) {
        String bin = "";
        while(dec > 0) {
            bin = (String.valueOf(dec % 2)) + bin;
            dec /= 2;
        }
        
        if (bin.equals("")) {
            bin += "0";
        }
        return bin;
    }
}