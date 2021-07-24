package DataStructure.Array;


import java.util.*;

public class ArrayDemo {
    static int data = 0;

    static int MaximumGlassHourSum = 0;

    public static void main(String[] args) {

        System.out.println("DataStructure.Array Demonstration");
        int[] arr = new int[] {1,4,2,53,21};
        findLargestElementInArray(arr);
        System.out.println();

        arr = new int[] {1,2,3,4,6,7,8,9,10};
        missingIntegerInGivenArrayFromRange(1 , 10 , arr);
        System.out.println();

        arr = new int[] {1,4,2,3,3};
        findduplicateNumberInArray(arr);
        System.out.println();

        arr = new int[] {2,4,1,5,32,8};
        largestAndSmallestDataInUnsortedArray(arr);

        System.out.println("Pair with given sum - ");
        findPairWithGivenSum(arr , 12);

        arr = new int[] {1,2,3,4,5,5,5,5,5,6};
        removeDuplicatesFromGivenSortedArray(arr);

        arr = new int[]{1,2,3,4,5};
        data = 0;
        reverseArray(arr , 0 , 4);
        System.out.println("\nReversed an array ");
        for(int i = 0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + "\t");
        }

        arr = new int[]{1,2,3,5,6};
        rotateGivenArray(arr , 6);
        System.out.println("\nRotated an array ");
        for(int i = 0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + "\t");
        }

        arr = new int[] {1,9,52,3,21,62,72,12};
        segregateEvenOddnumbers(arr);
        System.out.println("\nSegregated DataStructure.Array Output :- " + Arrays.toString(arr));


        System.out.println("\nNth Fibonacii number in Hexadecimal format :- ");
        String fibonaciiHexaForm = getNthFibonaciiNo(8);
        System.out.println("Fibonacii Number is :- " + fibonaciiHexaForm);


        System.out.println("\nHACKERRANK PROBLEM SOLVING TECHNIQUES");
        int[][] doubleArray = new int[][] {
                {-9, -9, -9 , 1, 1, 1 },
                {0 ,-9 , 0 , 4 ,3, 2},
                {-9 ,-9 ,-9,  1, 2 ,3},
                {0 , 0 , 8 , 6, 6 ,0},
                { 0,  0  ,0, -2 , 0 ,0},
                { 0 , 0  ,1 , 2, 4, 0}
        };

        int sum = hourGlassIn2DArray(doubleArray , 0 , 0);
        System.out.println("Maximum Hour Glass sum is :- " + sum);

        arr = new int[] {1,2,3,4,5};
        rotationOfAnArray(arr);

        frequencyOfValueInArray(new int[] {1,2,3,3,3,3,3,3,7,8} , 3);

        System.out.println("\nNumber of cycles by which array was rotated....");
        arr = new int[] {3,4,5,6,7,8,9,10,1,2};
        int pivotIdx = findPivotIndex(arr);
        if(pivotIdx == -1){
            System.out.println("Array is not rotated at all.");
        }else {
            System.out.println("Array is rotated by = " + (arr.length - (pivotIdx+1))%arr.length);
        }

        searchInSortedRotatedArray(new int[] {4,5,6,7,0,1,2} , 6);

        int[][] matrix = new int[][]{{1,3,5,7} , {10,11,16,20} , {23,30,34,60}};
        searchElementIn2DMatrix(matrix , 18);

        boolean isElement  = searchElementIn2DMatrixUsingSpaceReduction(matrix , 13 , matrix[0].length*(matrix.length-1));
        System.out.println("Element Found = " + isElement);

        List<String> letterList = letterCombinationsOfPhoneBook("234");
        System.out.println("All Letters combinations - " + letterList);

        System.out.println("\nFinding combinations of a,b,c,d such that a+b+c = d");
        int maxPossibleD = findCombinationOfabcd(new int[] {2,3,5,7,12});
        System.out.println("Maximum Possible value of D is = " + maxPossibleD);
    }

    private static boolean searchElementIn2DMatrixUsingSpaceReduction(int[][] matrix, int target , int position) {
        int row = position/matrix[0].length , col = 0;

        while (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length){
            if(matrix[row][col] == target)
                return true;

            else if(matrix[row][col] > target)
                row = row-1;
            else
                col = col+1;
        }

        return false;
    }

    private static int findCombinationOfabcd(int[] ints) {
        int maxD = Integer.MIN_VALUE;

        return maxD;
    }

    private static List<String> letterCombinationsOfPhoneBook(String digit) {

        String[] str = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        LinkedList<String> outputlist = new LinkedList<>();
        outputlist.add("");

        Objects.equals(10 , 20);

        for(int i=0 ; i<digit.length() ; i++){
            String corrsp = str[Character.getNumericValue(digit.charAt(i))];
            while (outputlist.peek().length() == i){
                String temp = outputlist.peek();
                outputlist.remove(temp);
                for(Character ch : corrsp.toCharArray()){
                    outputlist.add(temp+ch);
                }
            }
        }
        return outputlist;
    }

    private static void searchElementIn2DMatrix(int[][] matrix, int x) {
        int rowThatWeNeed = findClosestElementForRow(matrix , x);
        if(rowThatWeNeed == -1)
        {
            System.out.println("Element is not present inside the matrix.");
            return;
        }

        System.out.println("Desired row is = " +  rowThatWeNeed);
        int low = 0 , high = rowThatWeNeed , mid = 0;
        while (low <= high){
            mid  = (low+high)/2;
            if(matrix[rowThatWeNeed][mid] == x){
                System.out.println("Element is found at location - " + rowThatWeNeed+":"+mid);
                return;
            }
            if(matrix[rowThatWeNeed][mid]>x)
                high = mid-1;
            else
                low = mid+1;
        }
    }

    private static int findClosestElementForRow(int[][] matrix, int x) {
        int totalRowsPresent = matrix.length;
        int low = 0 , high = totalRowsPresent-1 , idx = -1;

        while (low <= high){
            int mid = (low+high)/2;
            int columnSize = matrix[0].length;
            if(x >= matrix[mid][0] && x <= matrix[mid][columnSize-1])
                return mid;

            if(x > matrix[mid][0])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    private static void searchInSortedRotatedArray(int[] arr , int x) {
        int pivotPosition = findPivotIndex(arr);
        if(arr[pivotPosition] == x){
            System.out.println("Element = " + x + " is found at location - " + pivotPosition);
            return;
        }
        if(arr[0] > x)
            binarySearch(arr , x , pivotPosition+1 , arr.length);
        else
            binarySearch(arr , x , 0 , pivotPosition-1);
    }

    public static void binarySearch(int[] arr , int x , int low , int high) {
        int idx = -1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == x)
            {
                idx = mid;
                break;
            }

            if(arr[mid]>x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println("Element = " + x + " is found at location - " + idx);
    }

    private static int findPivotIndex(int[] arr) {
        int idx = -1;
        if(arr.length == 0 || arr.length == 1)
            return 0;

        int low = 0 , high = arr.length-1 , mid = 0;
        while (low<=high){
            mid = (low + high)/2;

            if(mid<high && arr[mid]>arr[mid+1]){
                idx = mid;
                break;
            }

            if(mid>0 && arr[mid-1]>arr[mid]){
                idx = mid-1;
                break;
            }

            if(arr[low]<=arr[mid]){
                low = mid+1;
            }
            else
                high = mid-1;
        }

        System.out.println("Pivot Element Index = " + idx);
        return idx;
    }

    private static void frequencyOfValueInArray(int[] arr, int x) {
        int fOccurence = firstOccurenceOrLastOccurenceOfx(arr , x , true);
        int lOccurence = firstOccurenceOrLastOccurenceOfx(arr , x , false);
        System.out.println(fOccurence + "-" + lOccurence);
        System.out.println("Number of occurences of given element - " + (lOccurence - fOccurence + 1));

    }

    private static int firstOccurenceOrLastOccurenceOfx(int[] arr, int x , boolean isFirstOccurence) {
        int low = 0 , high = arr.length - 1 , idx = -1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == x){
                idx = mid;
                if(!isFirstOccurence)
                    low = mid+1;
                else
                    high = mid-1;
            }
            else if(arr[mid]>x)
                high = mid-1;
            else
                low = mid+1;
        }
        return idx;
    }

    private static void rotationOfAnArray(int[] arr) {

    }

    private static int hourGlassIn2DArray(int[][] doubleArray , int rowIndex , int colIndex) {
        // base case , final box we reached
        if(rowIndex == doubleArray.length-1 || (colIndex == doubleArray[0].length-1))
            return 0;

        if(isValidHourGlassIndex(doubleArray , rowIndex , colIndex)) {
           int currSum = doubleArray[rowIndex][colIndex] + doubleArray[rowIndex-1][colIndex]
                   + doubleArray[rowIndex+1][colIndex] + doubleArray[rowIndex-1][colIndex-1]
                   + doubleArray[rowIndex-1][colIndex+1] + doubleArray[rowIndex+1][colIndex-1]
                   + doubleArray[rowIndex+1][colIndex+1];

           if(currSum >= MaximumGlassHourSum)
               MaximumGlassHourSum = currSum;
        }

        hourGlassIn2DArray(doubleArray , rowIndex+1 , colIndex);
        hourGlassIn2DArray(doubleArray , rowIndex , colIndex +1);

        return MaximumGlassHourSum;
    }

    private static boolean isValidHourGlassIndex(int[][] doubleArray, int rowIndex , int colIndex) {
        if(rowIndex == 0 || rowIndex == (doubleArray.length-1) || colIndex == 0 ||colIndex == (doubleArray[0].length-1))
            return false;
        return true;
    }

    private static String getNthFibonaciiNo(int no) {
        if(no == 1)
            return "0";
        if(no == 2)
            return "1";

        long last = 0, secondLast = 1 , temp;
        for(int i = 2 ; i <= no ; i++)
        {
            temp = secondLast;
            secondLast = secondLast + last;
            last = temp;
        }

        Stack<Long> stack = new Stack<>();
        while(secondLast >= 16) {
            stack.push(secondLast%16);
            secondLast = secondLast/16;
        }
        stack.push(secondLast);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop().toString());
        }
        return sb.toString();
    }

    private static void segregateEvenOddnumbers(int[] arr) {
        int index = -1 , temp;
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] %2 == 0) {
                index++;
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    private static void reverseArray(int[] arr, int low , int high) {
        if(low>=high){
            return;
        }
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        reverseArray(arr , low+1 , high-1);
    }

    private static void rotateGivenArray(int[] arr , int rotationFactor) {
        if(rotationFactor > arr.length)
            rotationFactor = rotationFactor % arr.length;
        data = 0;
        reverseArray(arr , 0 , rotationFactor-1);
        data = rotationFactor;
        reverseArray(arr , rotationFactor, arr.length-1);
        data = 0;
        reverseArray(arr , 0 , arr.length-1);

    }

    private static void removeDuplicatesFromGivenSortedArray(int[] arr) {
        if(arr.length == 0 || arr.length == 1){
            System.out.println("Unique Index :- " + arr.length);
            return;
        }
//        int lastUniqueIndex = 0 , curr = arr[0], next;
//        for(int i = 0 ; i < arr.length-1 ; i++) {
//            next = arr[i+1];
//            if(next != curr) {
//                arr[lastUniqueIndex++] = curr;
//            }
//            curr = next;
//        }
//        arr[lastUniqueIndex] = arr[arr.length-1];
//
//        System.out.println("DataStructure.Array Without Duplicates - ");
//        for(int i = 0 ; i<=lastUniqueIndex ; i++) {
//            System.out.print(arr[i] + "\t");
//        }

        int idx = 0;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] != arr[i-1]){
                idx++;
                arr[idx] = arr[i];
            }
        }

        for(int i=0 ; i<=idx;i++)
            System.out.print(arr[i] + "\t");

    }

    private static void findPairWithGivenSum(int[] arr , int sum) {
        // 3 approaches here
        //brute force - O(n^2)
        int currSum = 0 , first = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            first = arr[i];
            for(int j = i+1 ; j<arr.length ; j++) {
                if(first + arr[j] == sum)
                    System.out.println("Pair found with given sum [Brute Force - O(n^2) time , O(1) space]- " + first + ":" + arr[j]);
            }
        }

        // Using Collection
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i<arr.length ; i++) {
            if(hashSet.contains(Math.abs(sum - arr[i]))) {
                System.out.println("Pair found with given sum [Using collection - O(n) time , O(n) space]- " + arr[i] + ":" + (sum-arr[i]));
            }
            else
                hashSet.add(arr[i]);
        }

        //Using 2 pointer technique
        Arrays.sort(arr);
        int leftptr = 0 , highptr = arr.length-1;
        while(leftptr < highptr) {
            if((arr[leftptr] + arr[highptr])== sum) {
                System.out.println("Pair found with given sum [Using sort - O(nlogn) time , O(1) space]- " + arr[leftptr] + ":" + arr[highptr]);
                break;
            }
            else if((arr[leftptr]+arr[highptr]) < sum)
                leftptr++;
            else
                highptr--;
        }
    }

    private static void largestAndSmallestDataInUnsortedArray(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] < smallest)
                smallest = arr[i];
            if(arr[i] > largest)
                largest = arr[i];
        }
        System.out.println("Smallest is :- " + smallest + " , largest is :- " + largest);
    }

    private static void findduplicateNumberInArray(int[] arr) {
        System.out.println("\n Finding Duplicate in DataStructure.Array using Set - O(n) time and space complexity");
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i = 0 ; i < arr.length ; i++) {
            if(hashSet.contains(arr[i]))
                System.out.println("Duplicate found :- " + arr[i]);
            else
                hashSet.add(arr[i]);
        }
        System.out.println("\n Finding Duplicate in DataStructure.Array using Abs function - O(n) time and O(1) space complexity");

        int xor = 0;
        for(int i=0 ; i<arr.length-1 ; i++){
            xor = xor ^ (i+1) ^ arr[i];
        }
        System.out.println("Duplicate Element - " + (xor^arr[arr.length-1]));
    }

    private static void missingIntegerInGivenArrayFromRange(int low, int high, int[] arr) {
        int totalSum = (high * (high+1))/2;
        int currSum = 0;
        for(int i = 0 ; i<arr.length ; i++)
            currSum = currSum + arr[i];
        System.out.println("Missing Element is :- " + (totalSum-currSum));
    }

    private static void findLargestElementInArray(int[] arr) {
        int maxElm = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++) {
            if(arr[i] > maxElm)
                maxElm = arr[i];
        }
        System.out.println("Max Element is :- " + maxElm);
    }

}
