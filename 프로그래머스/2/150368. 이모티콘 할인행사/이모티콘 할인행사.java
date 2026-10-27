import java.util.*;

class Solution {
    
    static int[] discounts = {10, 20, 30, 40};
    static int[] priceDiscounts; // i번째 이모티콘의 할인율
    static int len;
    static List<Info> list = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        len = emoticons.length;
        priceDiscounts = new int[len];
        
        seek(0, users, emoticons);
        
        list.sort((i1, i2) -> {
            if (i1.r() == i2.r()) {
                return i2.p() - i1.p();
            }
            return i2.r() - i1.r();
        });
        
        // for (Info i : list) {
        //     IO.println(i);
        // }
        
        return new int[]{list.get(0).r(), list.get(0).p()};
    }
    
    private void seek(int k, int[][] users, int[] emoticons) {
        if (k == len) {
            int register = 0;
            int totalPrice = 0;
            for (int[] user : users) {
                int discountCreteria = user[0]; // 할인 기준
                int priceCreteria = user[1]; // 가격 기준
                
                int price = 0;
                for (int i = 0; i < len; i++) {
                    if (priceDiscounts[i] >= discountCreteria) {
                        price += emoticons[i] * (100 - priceDiscounts[i]) / 100;
                    }
                }
                
                if (price >= priceCreteria) {
                    register++;
                } else {
                    totalPrice += price;
                }
            }
            list.add(new Info(register, totalPrice));
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            priceDiscounts[k] = discounts[i];
            seek(k+1, users, emoticons);
        }
    }
}

record Info(int r, int p) {} // r 이모티콘 플러스 가입 여부, p 구매비용 가격