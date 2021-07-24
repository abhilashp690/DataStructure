package DataStructure.BitSets;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

public class BitSetDemo {

    private static int N_BITS = 16;

    public static void main(String[] args) {
        BitSet b1 = new BitSet(N_BITS);
        BitSet b2 = new BitSet(N_BITS);

        System.out.println("B1 is - ");
        printBits(b1);
        System.out.println("\nB2 is - ");
        printBits(b2);


        setRandomBits(b1);
        setRandomBits(b2);

        System.out.println("\nHave Set Random Bits");
        System.out.println("Exact Numbers are - " + b1 + ":" + b2);
        System.out.println("B1 is - ");
        printBits(b1);
        System.out.println("\nB2 is - ");
        printBits(b2);

        System.out.println("\nPerforming OR Operation now ");
        b1.or(b2);
        System.out.println("Output of Or Operation is :- ");
        printBits(b1);

        System.out.println("\nB1 is - ");
        //b1.set(0);
        printBits(b1);
        System.out.println("\nB2 is - ");
        printBits(b2);

        System.out.println("\nFinal Output of b1 is :- " + b1.toString());
        System.out.println("Final Output of b2 is :- " + b2.toString());

        System.out.println("\nCardinality of b1 is :- " + b1.cardinality());
        System.out.println("Cardinality of b2 is :- " + b2.cardinality());

        b1.clear();
        b2.clear();

        System.out.println("\nB1 is - ");
        printBits(b1);
        System.out.println("\nB2 is - ");
        printBits(b2);

        printMissingNumber(new int[]{1, 2,  4, 6}, 6);
    }

    private static void printMissingNumber(int[] numbers, int count)
    {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
        for (int number : numbers)
        {
            bitSet.set(number - 1);
        }
        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++)
        {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }


    private static void setRandomBits(BitSet b) {
        Random r = new Random();
        for(int i=0 ; i<N_BITS/2 ; i++) {
            b.set(r.nextInt(N_BITS));
        }
    }

    private static void printBits(BitSet b) {
        for(int i = 0 ; i < N_BITS ; i++)
            System.out.print((b.get(i) == false ? "0" : "1") + "\t");
    }
}
