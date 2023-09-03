import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

class Solution {
    
    public String[] solution(String[] files) {
        
        List<File> fileList = new ArrayList<>();
        
        for (String file : files) {
            String head = null, number = null, tail = null;
            
            int i = 0, numCount = 0;
            for (; i < file.length(); i++) {
                if (file.charAt(i) >= '0' && file.charAt(i) <= '9') {
                    head = file.substring(0, i);
                    numCount++;
                    break;
                }   
            }
            
            int j = i;
            for (; i < file.length(); i++) {
                if (!(file.charAt(i) >= '0' && file.charAt(i) <= '9') || numCount > 5) {
                    number = file.substring(j, i);
                    j = i;
                    break;
                }
                numCount++;
            }
            
            if (number == null) {
                number = file.substring(j);
                tail = "";
            } else {
                tail = file.substring(j);
            }
            
            fileList.add(new File(head, number, tail));
        }
        
        Collections.sort(fileList, (f1, f2) -> {
            if (f1.headL.equals(f2.headL)) {
                return f1.num - f2.num;
            }
            return f1.headL.compareTo(f2.headL);
        });
        
        int i = 0;
        String[] answer = new String[fileList.size()];
        for (File file : fileList) {
            StringBuilder sb = new StringBuilder();
            answer[i++] = sb.append(file.head).append(file.number).append(file.tail).toString();
        }
        
        return answer;
    }
    
    private void printStr(String[] str) {
        System.out.printf("%d: ", str.length);
        for(String s : str) {
            System.out.printf("%s | ", s);
        }
        System.out.println();
    }
}

class File {
    String head;
    String number;
    String tail;
    String headL;
    int num;
    
    public File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.headL = head.toLowerCase();
        this.num = Integer.parseInt(number);
    }
}