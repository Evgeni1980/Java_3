package Geekbrains.HomeWork_4;

public class ABC {
    static Object mon = new Object();
    static volatile char currentLater = 'A';

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLater != 'A') {  // Если не "А" поток ждёт
                            mon.wait();
                        }
                        System.out.print("A");       // Если "А" печатает
                        currentLater = 'B';            // присваевает currentLater "В"
                        mon.notifyAll();               // Будит все остальные потоки ....
                    }
                }
            }catch (InterruptedException e) {
               e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLater != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLater = 'C';
                        mon.notifyAll();
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon) {
                        while (currentLater != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentLater = 'A';
                        mon.notifyAll();
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
