package StringDP;

class Pallindrome{
    int start;
    int end;

    public Pallindrome(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMaxLength(){
        return end-start+1;
    }

    @Override
    public String toString() {
        return "Pallindrome{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class LongestPallindromeSubString {
    public static void main(String[] args) {
        System.out.println("Longest Pallindrome Substring...");

        String s = "bbbab";
        Pallindrome pallindrome = new Pallindrome(0,0);

        maxPossibleSubStringPalindrome(s , pallindrome);
        System.out.println("Maximum Length of possible substring - " + pallindrome.getMaxLength() +" , substring - " + s.substring(pallindrome.start , pallindrome.end+1));
        System.out.println("Time Complexity is O(N^2)");
    }

    private static void maxPossibleSubStringPalindrome(String s , Pallindrome pallindrome) {
        for(int i=0;i<s.length()-1;i++){
            isMaxSubStringPalindrome(s , i , i, pallindrome);
            isMaxSubStringPalindrome(s , i , i+1 , pallindrome);
        }
    }

    private static void isMaxSubStringPalindrome(String s, int start , int end, Pallindrome pallindrome) {
        while (start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        if((end-start-1) > pallindrome.getMaxLength()){
            pallindrome.setStart(start+1);
            pallindrome.setEnd(end-1);
        }
    }
}
