package gui.w7.z14;

public class Buffer {
    private int[] wart;
    public int size;
    public int count = 0;
    int c = 10;

    public Buffer(int size) {
        this.size = size;
        wart = new int[size];
    }

    public synchronized int get() throws InterruptedException {
        int gget = wart[0];
        for (int i = 0; i < c; i++) {
            //wart[0] = wart[i];
            gget = wart[i];

        }
        c--;
        return gget;
    }


    public synchronized void put(int n) throws InterruptedException {
        if (count >= size) {
            System.out.println("Array is full. You cannot add more numbers");
        } else {
            wart[count] = n;
            count++;
        }
    }
}
