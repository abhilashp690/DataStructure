package EducativeIOThreadingQuestions;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BarberDemonstration {
    public static void main(String[] args) throws Exception{
        System.out.println("Barber Problem Demonstration .....");
        System.out.println("===========================================");

        Semaphore people = new Semaphore(3);
        Lock entranceLock = new ReentrantLock();
        new Barber(people , "Barber").start();

        for(int i=0 ; i<10 ; i++) {
            new BarberShop(people , "Customer"+i , entranceLock).start();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}

class Barber extends Thread {

    Semaphore customer = null;

    public Barber(Semaphore customer, String name) {
        this.customer = customer;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
               while (customer.availablePermits() < 3) {
                   customer.release();
                   System.out.println("Barber is currently cutting customer's hair.");
                   TimeUnit.SECONDS.sleep(3);
               }
               System.out.println("Barber is currently sleeping , as no customers are available right now");
               TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}


class BarberShop extends Thread {

    Semaphore customer = null;
    Lock entranceLock = null;

    public BarberShop(Semaphore customer, String name, Lock entranceLock) {
        this.customer = customer;
        setName(name);
        this.entranceLock = entranceLock;
    }

    @Override
    public void run() {
        try {
            entranceLock.lock();
            System.out.println(Thread.currentThread().getName() + " has entered the shop for the haircut.");
            if(!checkIfRequestAllowed()){
                System.out.println("No more room for new customer , please come back later");
                return;
            }
            customer.acquire();
            System.out.println(Thread.currentThread().getName() + " is currently sitting on the bench.");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            System.out.println("Exception at barber shop");
        }
        finally {
            entranceLock.unlock();
        }
    }

    public boolean checkIfRequestAllowed() {
        return customer.availablePermits() > 0;
    }
}
