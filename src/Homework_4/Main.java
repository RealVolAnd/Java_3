package Homework_4;

public class Main {
    static Object mon = new Object();
    static volatile int currentNumber = 1;
    static final int num = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentNumber != 1) {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentNumber = 2;
                        mon.notifyAll();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentNumber != 2) {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentNumber = 3;
                        mon.notifyAll();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < num; i++) {
                    synchronized (mon) {
                        while (currentNumber != 3) {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentNumber = 1;
                        mon.notifyAll();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}
