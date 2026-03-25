import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        // 1. <div title="..."> 태그를 찾아 분리
        // <div> 태그가 시작될 때마다 title을 출력하고 내부 내용을 처리합니다.
        Pattern divPattern = Pattern.compile("<div title=\"([^\"]*)\">");
        Pattern pPattern = Pattern.compile("<p>(.*?)</p>");
        
        // 전체 구조 파싱: <div ...>와 그 안의 내용들
        String[] divs = html.split("</div>");
        
        for (String divSection : divs) {
            Matcher divMatcher = divPattern.matcher(divSection);
            if (divMatcher.find()) {
                // title : {title_name} 출력
                System.out.println("title : " + divMatcher.group(1));
                
                // 해당 div 내의 모든 <p> 태그 찾기
                Matcher pMatcher = pPattern.matcher(divSection);
                while (pMatcher.find()) {
                    String pContent = pMatcher.group(1);
                    
                    // 1) 모든 태그 제거
                    pContent = pContent.replaceAll("<[^>]*>", "");
                    
                    // 2) 양 끝 공백 제거 및 연속된 공백을 하나로 축소
                    pContent = pContent.trim().replaceAll("\\s{2,}", " ");
                    
                    System.out.println(pContent);
                }
            }
        }
    }
}
