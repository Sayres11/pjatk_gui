import java.util.HashMap;
import java.util.Map;

public class Cennik {
    HashMap<String, Double> cennikMap = new HashMap<>();
    Map<String, Double> hurCennaMap = new HashMap<>();

    private static Cennik cennik;
    static String smak;
    static String herbata;
    static double cenna;
    static double hurCenna;
    static double hurKg;

    public static Cennik pobierzCennik() {
        if (cennik == null) {
            cennik = new Cennik();

        }
        return cennik;
    }


    public void dodaj(String herbata, String smak, double cenna, double hurCenna, double hurKg) {
        this.herbata = herbata;
        this.smak = smak;
        this.cenna = cenna;
        this.hurCenna = hurCenna;
        this.hurKg = hurKg;
        cennikMap.put(smak, cenna);
        hurCennaMap.put(smak, hurCenna);
    }

    public void dodaj(String herbata, String smak, double cenna) {
        this.herbata = herbata;
        this.smak = smak;
        this.cenna = cenna;
        cennikMap.put(smak, cenna);
    }

    public String toString() {
        return "Herbata: " + herbata + ", smak: " + smak + ", cena: " + cenna;
    }
}
