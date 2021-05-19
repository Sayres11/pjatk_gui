package mypackage.Swing;


import javax.swing.*;

public class Factory extends Thread {
    public boolean syka = false;
    int wasProduced = 0;
    private final JLabel jl = new JLabel(0 + " balloons produced");
    private final JSlider js = new JSlider(100, 3000, 1500);

    public JLabel getJl() {
        return jl;
    }

    public JSlider getJs() {
        return js;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (syka) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int colorId = (int) (Math.random() * 17);
            Ballon tmp = new Ballon(ColorsForBalloons.COLOR1.getColor(colorId));
            jl.setText(++wasProduced + " balloons produced");
            Storage.storage.add(tmp);
            synchronized (this) {
                if (Storage.storage.size() >= 90) {
                        Storage.storage.removeAll(Storage.storage);
                    System.out.println("90 elements were removed");
                }
            }
            System.out.println(tmp + "    was added");
            try {
                Thread.sleep(js.getValue());
            } catch (InterruptedException e) {
            }
        }

    }

    public void continueMake(){
        synchronized (this){
            syka = false;
            this.notify();
        }
    }

    public void stopp() {
        synchronized (this) {
            syka = true;
        }
    }
    public void deletee(){
        synchronized (this){
            Factory.this.interrupt();
            System.out.println("delete");
        }
    }
}


