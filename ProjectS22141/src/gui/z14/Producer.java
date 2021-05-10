package gui.w7.z14;

public class Producer implements Runnable {
    private final Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }


    @Override
    public void run() {
        while (true) {
            try {
                synchronized (b) {
                    if(b.count == b.size){
                        System.out.println("Array is full");
                        b.notify();
                        b.wait();

                    }
                    int r = (int) (Math.random() * 1000);
                    b.put(r);
                    System.out.println("Producer: " + r);
                    //System.out.println("producer - debug");
                }
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
