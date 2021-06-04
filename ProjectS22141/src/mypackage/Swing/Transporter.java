package mypackage.Swing;

import javax.swing.*;

public class Transporter extends Thread {

    static int wasDeliv = 0;
    private final JLabel jl = new JLabel("waiting");
    boolean sk = false;

    public Transporter() {

    }

    public JLabel getJl() {
        return jl;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (sk) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Storage.storage.size() > 10) {
                    jl.setText("loading");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                    }
                    for (int j = 1 + wasDeliv; j <= 10 + wasDeliv; j++) {
                        System.out.println(Storage.storage.get(0) + "    was taken on a board");
                        Storage.storage.remove(0);
                    }
                    wasDeliv += 10L;
                    System.out.println("transporting 10 items");
                    try {
                        jl.setText("delivering");
                        Thread.sleep(10000);
                        jl.setText("delivered");
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    void continueLoad() {
        synchronized (this) {
            sk = true;
        }

    }

    void stopLoad() {
        synchronized (this) {
            sk = false;
            this.notify();

        }
    }
}
