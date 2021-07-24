package MultiThreading.PrintingEvenOdd.Uisng2Threads;

public class Threading {
    public static void main(String[] args) {
        new EvenNumber(12).start();
        new OddNumber(13).start();
    }
}

class EvenNumber extends Thread{
    int counter = 0;
    int maxLimit;

    public EvenNumber(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void run() {
        while (counter <= maxLimit){
            try {
                System.out.println("Even = " + counter);
                counter = counter + 2;
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

class OddNumber extends Thread{
    int counter = 1;
    int maxLimit;

    public OddNumber(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void run() {
        while (counter <= maxLimit){
            try {
                System.out.println("Odd = " + counter);
                counter = counter + 2;
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
