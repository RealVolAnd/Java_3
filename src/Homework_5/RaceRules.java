package Homework_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class RaceRules {
    private int carsCount;
    private int carsReady = 0;
    private CyclicBarrier readyToStart;
    private Semaphore tunnelWidth;
    private CountDownLatch waitingForFinish;

    public RaceRules(int carsCount, int tunnelWidth) {
        this.carsCount = carsCount;
        readyToStart = new CyclicBarrier(carsCount + 1);
        this.tunnelWidth = new Semaphore(tunnelWidth);
        waitingForFinish = new CountDownLatch(carsCount);
    }

    public void ready() {
        try {
            readyToStart.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void tunnelIn() {
        try {
            tunnelWidth.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tunnelOut() {
        tunnelWidth.release();
    }

    public void setWaitingForFinish() {
        try {
            waitingForFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countDownWaitingForFinish() {
        waitingForFinish.countDown();
    }

    public int getReadyCarsCount() {
        return readyToStart.getNumberWaiting();
    }

}
