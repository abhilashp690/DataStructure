package DataStructure.String;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println("String Compression Demonstration .... ");
        String s1 = "aaaaab";
        compressString(s1);
    }

    private static void compressString(String s) {
        StringBuilder str = new StringBuilder("");
        if(s == null || s.isEmpty())
            return;

        int currentCount = 1;
        char lastChar = s.charAt(0);

        for(int i=1 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(lastChar != ch){
                str.append(lastChar).append(currentCount);
                lastChar = ch;
                currentCount = 1;
            }
            else {
                currentCount++;
            }
        }
        String compressedString = str.append(lastChar).append(currentCount).toString().substring(0 , (Math.min(s.length() , str.length())));

        System.out.println("Compressed String is :- " + compressedString);
    }
}
