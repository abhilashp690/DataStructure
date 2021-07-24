package EducativeIOThreadingQuestions;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class UberRideProblem {
    public static void main(String[] args) {
        System.out.println("Uber Ride Problem Demonstration ....");
        System.out.println("=====================================================");

        Semaphore democrat = new Semaphore(4);
        Semaphore republican = new Semaphore(4);
        ReentrantLock mutex = new ReentrantLock();

        String [] USParty = new String[] {"DEMOCRAT" , "REPUBLICAN" , "DEMOCRAT" , "REPUBLICAN"};
        for(int i=0 ; i<14 ; i++){
            int idx = new Random().nextInt(4);
            new UberRide(democrat , republican , USParty[idx], mutex).start();
        }
    }
}

class UberRide extends Thread {

    volatile Semaphore democrats = null;
    volatile Semaphore republicans = null;
    ReentrantLock mutex;

    public UberRide(Semaphore democrats , Semaphore republicans , String name , ReentrantLock mutex) {
        this.democrats = democrats;
        this.republicans = republicans;
        setName(name);
        this.mutex = mutex;
    }

    @Override
    public void run() {
        try {
            mutex.lock();
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Incoming REQUEST for party - " + Thread.currentThread().getName() + " , TOTAL democrat available permit = " + democrats.availablePermits() + " , republican available permit = " + republicans.availablePermits());
            if (Thread.currentThread().getName().equals("DEMOCRAT"))
                democratSeated();
            else
                republicanSeated();
        }catch (InterruptedException e){

        }finally {
            mutex.unlock();
        }
    }

    public void democratSeated() {
        try{
            if(republicans.availablePermits() <= 2){
                if(democrats.availablePermits() <= 3){
                    republicans.release();
                    republicans.release();
                    democrats.release();
                    System.out.println("2 Republicans along with 2 Democrats taking ride now..." + new Date());
                    TimeUnit.SECONDS.sleep(6);
                }
                else
                    democrats.acquire();
            } else {
                if(democrats.availablePermits() == 1){
                    democrats.release();
                    democrats.release();
                    democrats.release();
                    System.out.println("All 4 Democrats travelling now...." + new Date());
                    TimeUnit.SECONDS.sleep(4);
                } else
                    democrats.acquire();
            }
        }catch (InterruptedException e){
            System.out.println("Error while democrat seating arrangement.");
        }
    }

    public void republicanSeated() {
        try{
            if(democrats.availablePermits() <= 2){
                if(republicans.availablePermits() <= 3){
                    democrats.release();
                    democrats.release();
                    republicans.release();
                    System.out.println("2 Republicans along with 2 Democrats taking ride now..." + new Date());
                    TimeUnit.SECONDS.sleep(6);
                }
                else
                    republicans.acquire();
            } else {
                if(republicans.availablePermits() == 1){
                    republicans.release();
                    republicans.release();
                    republicans.release();
                    System.out.println("All 4 Republicans travelling now...." + new Date());
                    TimeUnit.SECONDS.sleep(4);
                } else
                    republicans.acquire();
            }
        }catch (InterruptedException e){
            System.out.println("Error while republican seating arrangement.");
        }
    }
}
