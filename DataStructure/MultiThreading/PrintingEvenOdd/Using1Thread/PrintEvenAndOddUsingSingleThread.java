package MultiThreading.PrintingEvenOdd.Using1Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenAndOddUsingSingleThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Printing Even and odd using 2 threads...");
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        EvenOdd evenOdd = new EvenOdd(10 , lock , condition);
        new Thread(evenOdd , ThreadNames.ODD.name()).start();
        new Thread(evenOdd , ThreadNames.EVEN.name()).start();

    }

}

class EvenOdd extends Thread {

    volatile int counter = 0;
    int maxCapacity;
    Lock reEntrant;
    Condition condition;

    public EvenOdd(int maxCapacity , Lock lock , Condition condition) {
        this.maxCapacity = maxCapacity;
        this.reEntrant = lock;
        this.condition = condition;
    }

    public void run() {

        while (counter <= maxCapacity) {
            try {
                reEntrant.lock();
                if (Thread.currentThread().getName().equals(ThreadNames.ODD.name())) {
                   while (counter % 2 == 0)
                     condition.await();

                   System.out.println(Thread.currentThread().getName() + "-" + counter);
                   counter++;
                   condition.signalAll();
                } else {
                   while (counter % 2 != 0)
                      condition.await();

                   System.out.println(Thread.currentThread().getName() + "-" + counter);
                   counter++;
                   condition.signalAll();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                reEntrant.unlock();
            }
        }

    }
}
