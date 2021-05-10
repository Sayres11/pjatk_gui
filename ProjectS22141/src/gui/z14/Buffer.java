package gui.w7.z14;

public class Buffer {
    private int[] wart;
    private int count = 0;
    public int size;

    public Buffer(int size) {
        this.size = size;
        wart = new int[size];
    }

    public synchronized int get() throws InterruptedException {
        int gget = wart[0];
        return gget;
    }


    public synchronized void put(int n) throws InterruptedException {
        wait();
        wart[count] = n;
        count++;
        notify();
    }
}
