class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        System.out.println("1. " + new_id);

        new_id = new_id.replaceAll("[^\\w-_.]", "");
        System.out.println("2. " + new_id);
        
        new_id = new_id.replaceAll("\\.{2,}", ".");
        System.out.println("3. " + new_id);
        
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        System.out.println("4. " + new_id);
        
        if (new_id.length() == 0)
            new_id = "a";
        
        System.out.println("5. " + new_id);
        
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            System.out.println("6. " + new_id);
            if (new_id.substring(14).equals(".")) {
                new_id = new_id.replaceAll("\\.$", "");
                System.out.println("6-1. " + new_id);
            }
        } else if (new_id.length() <= 2) {
            while(new_id.length() != 3)
                new_id += new_id.substring(new_id.length()-1);
        }
        System.out.println(new_id);
            
        return new_id;
    }
}