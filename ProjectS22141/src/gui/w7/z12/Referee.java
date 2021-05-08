package gui.w7.z12;

public class Referee extends Thread {

    Player[] pl;

    private int time;

    public Referee(int time, Player[] pl) {
        this.time = time;
        this.pl = pl;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < time) {
                i++;
                System.out.println("Czas" + i);
                sleep(1000);
            }
        } catch (InterruptedException e) {
            return;
        }
        pl[0].interrupt();
        pl[1].interrupt();
    }

    public void startGame() {
        this.start();
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        pl[0].start();
        pl[1].start();
    }

    public void result() {
        try {
            System.out.println("\nwyniki " + pl[0].nazwa + " " + pl[0].score);
            System.out.println("wyniki " + pl[1].nazwa + " " + pl[1].score);
            if (pl[0].score > pl[1].score) {
                System.out.println(pl[0].nazwa + " wygrał");
            } else if (pl[1].score > pl[0].score) {
                System.out.println(pl[1].nazwa + " wygrał");
            } else {
                System.out.println("równy wynik");
            }
        } catch (Exception e) {

            return;
        }

    }
}
