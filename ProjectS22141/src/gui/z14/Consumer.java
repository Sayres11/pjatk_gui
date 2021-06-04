package gui.z14;

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
                    if (b.count != b.size) {
                        System.out.println("Array is not full. Please wait ");
                        b.wait();
                    }
                    b.get();
                    // System.out.println("consumer - debug");
                    System.out.println("Consumer:" + b.get());
                    Thread.sleep((int) (Math.random() * 2000));
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

