package DataStructure.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowDemonstration {
    public static void main(String[] args) {
        maxSubStringWithUniqueCharacters("abcdasd");

        maxSlidingWindowProblem(new int[] {1,-1} , 2);
    }

    private static void maxSlidingWindowProblem(int[] nums, int k) {
        int[] resultant = new int[nums.length];

        int arrayEnd = 0,arrayStart = 0;
        int firstCurrMaxInWindow = Integer.MIN_VALUE , secondCurrMaxInWindow = Integer.MIN_VALUE;

        for(arrayEnd=0 ; arrayEnd<nums.length ; arrayEnd++){
            if(arrayEnd >= (k-1)){
                resultant[arrayStart] = Math.max(nums[arrayEnd] , firstCurrMaxInWindow);

                if(nums[arrayEnd] > firstCurrMaxInWindow){
                    secondCurrMaxInWindow = firstCurrMaxInWindow;
                    firstCurrMaxInWindow = nums[arrayEnd];
                }
                else {
                    if(firstCurrMaxInWindow == nums[arrayStart]){
                        firstCurrMaxInWindow = secondCurrMaxInWindow;
                    }
                    for(int i=0;i<k;i++){
                        if(nums[i] != firstCurrMaxInWindow){
                            secondCurrMaxInWindow = Math.max(secondCurrMaxInWindow , nums[i]);
                        }
                    }
                }
                arrayStart++;
            }
            else {
                if(nums[arrayEnd] >= firstCurrMaxInWindow){
                    secondCurrMaxInWindow = firstCurrMaxInWindow;
                    firstCurrMaxInWindow = nums[arrayEnd];
                }
                else if(nums[arrayEnd] > secondCurrMaxInWindow) {
                    secondCurrMaxInWindow = nums[arrayEnd];
                }
            }
        }
        System.out.println(Arrays.toString(resultant));
    }


    public static void maxSubStringWithUniqueCharacters(String s) {
        Map<Character,Integer> wordMap = new HashMap<Character,Integer>();

        int wordStart = 0;
        int maxSubStringLengthOfUniqueCharacters = 0;

        for(int windowEnd=0 ; windowEnd < s.length() ; windowEnd++ ){
            if(wordMap.get(s.charAt(windowEnd)) == null){
                wordMap.put(s.charAt(windowEnd) , windowEnd);
                maxSubStringLengthOfUniqueCharacters = Math.max(maxSubStringLengthOfUniqueCharacters , windowEnd-wordStart+1);
            }

            else{
                int windowShrinkingIndex = wordMap.get(s.charAt(windowEnd));
                while(wordStart<=windowShrinkingIndex){
                    wordMap.remove(s.charAt(wordStart));
                    wordStart++;
                }
                wordMap.put(s.charAt(windowEnd) , windowEnd);
            }
        }
        System.out.println("Maximum substring with unique characters - " + maxSubStringLengthOfUniqueCharacters);
    }
}
