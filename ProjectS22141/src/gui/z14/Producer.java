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
                    if(b.count != b.size) {
                        int r = (int) (Math.random() * 1000);
                        b.put(r);
                        System.out.println(r);
                        System.out.println("producer - debug");
                        Thread.sleep(1000);
                        b.notifyAll();
                    }
                }
                //Thread.sleep(10000);
            } catch(InterruptedException e){
                return;
            }
        }
    }
}
