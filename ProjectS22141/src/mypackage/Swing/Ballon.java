package mypackage.Swing;
public class Ballon {
    long uniqNumber;
    static long inc=1L;
    ColorsForBalloons balloonColor;

    public Ballon(ColorsForBalloons balloonColor) {
        uniqNumber =inc++;
        this.balloonColor = balloonColor;
    }

    @Override
    public String toString(){
        return uniqNumber + " " + balloonColor;
    }
}
