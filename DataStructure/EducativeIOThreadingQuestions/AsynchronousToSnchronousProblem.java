package EducativeIOThreadingQuestions;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsynchronousToSnchronousProblem {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Asynchronous processing to synchronous processing....");
        System.out.println("=================================================");

        CountDownLatch latch = new CountDownLatch(1);
        new Thread(new SynchronousExecutor(latch) , "CountDownLatchDemonstration").start();

        latch.await();
        System.out.println("Main Thread has completed processing .....");

         CountDownLatch latch1 = new CountDownLatch(1);
         Thread t = new Thread(new SynchronousExecutor(latch1) , "JoinedThreadDemonstration");
         t.start();
         t.join();
         System.out.println("Waiting for the response from async thread , Main thread is blocked.");
    }
}

class SynchronousExecutor extends AsyncExecutorCannotBeModified implements Runnable{

    CountDownLatch latch = null;

    public SynchronousExecutor(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        super.execute();
        latch.countDown();
    }
}


class AsyncExecutorCannotBeModified extends Thread{

    @Override
    public void run() {
        execute();
    }

    public void execute(){
        try {
            System.out.println(Thread.currentThread().getName() + " is doing some high computation work here..");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}