package EducativeIOThreadingQuestions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriterProblem {
    public static void main(String[] args) {
        System.out.println("Demonstration of the reader-writer problem.");
        System.out.println("Conditions to consider - 1].When writer is writing , no reader/writer is allowed");
        System.out.println("2].When reader is reading,allow multiple readers to read but restrict any writer to write.");

        System.out.println("========================================================================================================");
        Lock writeLock = new ReentrantLock();
        Lock readLock = new ReentrantLock();
        ReadWriteLockUtility utility = new ReadWriteLockUtility(writeLock , readLock);
        new WriterThread(utility , "Writer1").start();
        new ReaderThread(utility , "Reader1").start();
        new ReaderThread(utility , "Reader2").start();
        new WriterThread(utility, "Writer2").start();
        new ReaderThread(utility, "Reader3").start();
        new WriterThread(utility, "Writer3").start();
    }
}

class ReaderThread extends Thread {

    ReadWriteLockUtility utitlity = null;

    public ReaderThread(ReadWriteLockUtility utility , String name) {
        this.utitlity = utility;
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Current Reader Thread - " + Thread.currentThread().getName()+ " is trying to acquire the lock now - ");
        utitlity.acquireReadLock();
        utitlity.releaseReadLock();
    }

}

class WriterThread extends Thread {

    ReadWriteLockUtility utitlity = null;

    public WriterThread(ReadWriteLockUtility utility , String name) {
        this.utitlity = utility;
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Current Writer Thread - " + Thread.currentThread().getName() + " is trying to acquire the lock now");
        utitlity.acquireWriteLock();
        utitlity.releaseWriteLock();
    }
}


class ReadWriteLockUtility {

    Lock writeLock = null;
    //Lock readLock = null;
    volatile boolean isWriterPresent = false;
    volatile int readerCount = 0;

    public ReadWriteLockUtility(Lock writeLock , Lock readLock) {
        this.writeLock = writeLock;
        //this.readLock = readLock;
    }

    public void acquireReadLock() {
        while(isWriterPresent) {
            try {
                System.out.println("Reader - " + Thread.currentThread().getName() + " , is waiting for writer to finish its execution.");
                TimeUnit.SECONDS.sleep(4);
            }catch (InterruptedException e){
                System.out.println("Exception while waiting for writer thread");
            }
        }

        while(!isWriterPresent){
            try {
                readerCount++;
                System.out.println("Reader Thread - " + Thread.currentThread().getName() + " , is reading now.");
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                System.out.println("Exception occured while reading....");
            }
            break;
        }
    }

    public void acquireWriteLock() {
        try {
            while(readerCount != 0){
                try {
                    System.out.println("Waiting for reader threads to complete their reading first.");
                    TimeUnit.SECONDS.sleep(2);
                }catch (InterruptedException e){
                    System.out.println("Problem while waiting to acquire read lock.");
                }
            }
            while (readerCount == 0) {
                writeLock.lock();
                System.out.println("Writer Thread - " + Thread.currentThread().getName() + " is successfully writing now.");
                isWriterPresent = true;
                TimeUnit.SECONDS.sleep(10);
                break;
            }
        } catch(InterruptedException e){
            System.out.println("Exception while writing.....");
        }
    }

    public void releaseReadLock() {
        System.out.println("Reader Thread - " + Thread.currentThread().getName() + " , has finished reading");
        readerCount --;
    }

    public void releaseWriteLock() {
           writeLock.unlock();
           isWriterPresent = false;
        System.out.println("Writer Thread - " + Thread.currentThread().getName() + " , has finished writing.");
    }
}
