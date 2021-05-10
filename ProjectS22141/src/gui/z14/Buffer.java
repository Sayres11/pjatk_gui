package gui.w7.z14;

public class Buffer {
    private int[] wart;
    public int count = 0;
    public int size;

    public Buffer(int size) {
        this.size = size;
        wart = new int[size];
    }

    public synchronized int get() throws InterruptedException {
        int gget = wart[0];
        for (int i = 0; i < count - 1; i++) {
           wart[i] = wart[i+1];

        }
        count--;
        return gget;
    }


    public synchronized void put(int n) throws InterruptedException {
        wart[count++] = n;
    }
}
