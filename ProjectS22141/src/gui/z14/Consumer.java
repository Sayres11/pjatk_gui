package gui.w7.z14;

public class Consumer implements Runnable {
    private final Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (b) {
                    b.get();
                    System.out.println("consumer - debug");
                }
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

