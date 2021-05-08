import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class subclass {
    List<Herbata> herbataKlienta = new ArrayList<>();
    ArrayList <Herbata> koszykHerbatyKlienta = new ArrayList<>();
    static HashMap<String, Double> supermetoda = new HashMap<>();
    Cennik cennik = Cennik.pobierzCennik();
    Klient klient;

    public subclass(Klient klient)
    {
        this.klient = klient;
    }

    @Override
    public String toString() {
        String listaZakupowKlienta = klient.name + ": ";
        if(herbataKlienta.size()==0){
            listaZakupowKlienta += "-- pusto \n";
            return listaZakupowKlienta;
        }
        listaZakupowKlienta +="\n";
        for (Herbata a :
                herbataKlienta) {
            if (cennik.cennikMap.get(a.smak) == null) {
                a.cena = -1.0;
                listaZakupowKlienta += a.typ + ", smak: " + a.smak + ", ilość " + a.waga + " kg, cena " + a.cena + "\n";
            } else if (cennik.hurCennaMap.get(a.smak) != null && a.waga >= 4) {
                a.cena = cennik.hurCennaMap.get(a.smak);
                listaZakupowKlienta += a.typ + ", smak: " + a.smak + ", ilość " + a.waga + " kg, cena " + a.cena + "\n";
            } else {
                a.cena = cennik.cennikMap.get(a.smak);
                listaZakupowKlienta += a.typ + ", smak: " + a.smak + ", ilość " + a.waga + " kg, cena " + a.cena + "\n";
            }
        }
        return listaZakupowKlienta;
    }
}