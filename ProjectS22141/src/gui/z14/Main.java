package gui.z14;

public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer(10);
        Consumer c = new Consumer(b);
        Producer p = new Producer(b);
        Thread cons = new Thread(c);
        Thread prod = new Thread(p);
        cons.start();
        prod.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            cons.interrupt();
            prod.interrupt();
        }
    }
}