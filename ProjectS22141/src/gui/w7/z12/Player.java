package gui.w7.z12;

public class Player extends Thread {
    String nazwa;
    int score = 0;
    int buffer = 0;

    public Player(String nazwa) {
        this.nazwa = nazwa;
    }

    public void run() {
        try {
            while (true) {
                buffer = (int) (Math.random() * 100);
                score += buffer;
                System.out.println(nazwa +": "+ buffer);
                sleep((int) (Math.random() * 100) + 1000);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
