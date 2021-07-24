package DataStructure.BitSets.BitOperator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicHack {

    static Set<String> powerSet = new HashSet<>();

    public static void main(String[] args) {
        checkIfNumberIsEvenOrOdd(3);
        checkifTwoNumbersAreOpposite(4 , -8);
        addOneToANumber(-9);

        positionOfOnlySetBitInaNumber(1);
        checkIfIntegerIsPowerOf2(4);

        findPositionOfRightMostSetBit(8);
        checkIfNumberIsEvenParityOrOdd(-2147483648);

        calculateAbsoluteOfNumberWithoutFunction(-5);

        powerNumberToNextPowerOftwo(3);
        powerNumberToPreviousPower(9);

        reverseBinaryNumber(-371);
        swapTwoBitsInNumber(31 , 2 , 6);

        swapAdjacentBitsOfANumber(761622921);

        continousSubStringCombination(new Character[] {'x' , 'y' , 'z' , 'm'});


    }

    private static void continousSubStringCombination(Character[] characters) {
        Set<String> set = new HashSet<>();
        String prefix="";
        for(int i=0 ; i<characters.length ;i++){
            set.add(characters[i].toString());
            prefix = prefix+characters[i].toString();
            for(int j=i+1 ; j<characters.length ; j++){
                prefix = prefix + characters[j];
                set.add(prefix);
            }
            prefix="";
        }
        System.out.println("Contigous Sub Array - " + set);
    }

    private static void powerSetOfX(Character[] characters) {

    }

    private static void swapAdjacentBitsOfANumber(int no) {
      int getEvenIndex =  Integer.parseInt("01010101010101010101010101010101" , 2);
      int oddIndex = Integer.parseInt("00101010101010101010101010101010" , 2);

      int evenBits = no & getEvenIndex;
      int oddBits = no & oddIndex;

      int resultSet=0;
      for(int i=0 ; i<Integer.SIZE ; i++){
          resultSet = resultSet << (evenBits&1);
          resultSet = resultSet << (oddBits&1);
          evenBits = evenBits>>1;
          oddBits = oddBits>>1;
      }
        System.out.println("Result is - " + resultSet);
    }

    private static void swapTwoBitsInNumber(int no, int idx1, int idx2) {
        int temp1 = (no>>idx1)&1;
        int temp2 = (no>>idx2)&1;
        System.out.println("Temp1-"+temp1 + " : temp2 - " + temp2);
        if(temp1 == temp2) {
            System.out.println("No Need to swap , both are same");
            return;
        }
        no = no ^ (1<<idx2);
        no = no ^ (1<<idx1);
        System.out.println("Number after swapping the bits is - " + no);
    }

    private static void reverseBinaryNumber(int no) {
        int k=0;
        while (no != 0) {
            k = ((k<<1) | (no & 1));
            no = no >>> 1;
        }
        System.out.println("Reverse is "  +  k);
    }

    private static void powerNumberToPreviousPower(int no) {
        int data = (int)(Math.log(no)/Math.log(2));
        System.out.println("Number to previous power of two is - "+ (1<<data));
    }

    private static void powerNumberToNextPowerOftwo(int no) {
        no = no-1;
        while((no & (no-1)) != 0){
            no = (no & (no-1));
        }
        System.out.println("Nearest Power of two is - " + (no << 1));
    }

    private static void calculateAbsoluteOfNumberWithoutFunction(int no) {

    }

    private static void findAbsoluteOfNumberWithoutLoopBranch(int no) {

    }

    private static void checkIfNumberIsEvenParityOrOdd(int no) {
        boolean parity=false;

        while (no>0){
            no = (no & (no-1));
            parity = !parity;
        }

        if(parity)
            System.out.println("Odd Parity Number....");
        else
            System.out.println("Even Parity Number....");
    }

    private static void findPositionOfRightMostSetBit(int no) {
        System.out.println("Idea is to first do (n & (n-1)) that will reset right most 1 bit to 0 then do xor with original number , this will ensure only 1 '1' is present.");

        int idx = 0;
        no = ((no & (no-1))^ no);
        while(no > 0){
            no = no >> 1;
            idx++;
        }
        System.out.println("RightMost Bit 1 is - " + (idx-1));

    }

    private static void checkIfIntegerIsPowerOf2(int no) {
        System.out.println("Any number is power of two if and only iff it has atmost 1 bit set,therefore doing n&(n-1) if returns 0 then guaranteed only 1 bit was set.");
        if((no & (no-1)) != 0)
            System.out.println("Number is not a power of two");
        else
            System.out.println("Number is a power of two");
    }

    private static void positionOfOnlySetBitInaNumber(int no) {
        int pos = 0;
        while(no > 0)
        {
            pos++;
            no = no>>1;
        }
        System.out.println("Only Set Bit in number is - " + (pos-1));
    }

    private static void addOneToANumber(int no) {
        System.out.println("Addition = " + (-~no));
    }

    private static void checkifTwoNumbersAreOpposite(int no1, int no2) {
        if((no1^no2)<0)
            System.out.println("Numbers are of opposite signs");
        else
            System.out.println("Numbers are of same sign");
    }

    private static void checkIfNumberIsEvenOrOdd(int no) {
        if((no & 1) == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
