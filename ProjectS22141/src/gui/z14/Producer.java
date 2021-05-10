package gui.w7.z14;

public class Producer implements Runnable {
    private final Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }


    @Override
    public void run() {
        while (true){
            try {
                synchronized (b) {
                    int r = (int) (Math.random() * 1000);
                    b.put(r);
                    b.notifyAll();
                    System.out.println("producer - debug");
                }
                Thread.sleep(1000);
            } catch(InterruptedException e){
                return;
            }
        }
    }
}
