public class Koszyk extends subclass {

    public Koszyk(Klient kl) {
        super(kl);
        //System.out.println("klient created - debug");
    }

    @Override
    public String toString() {
        //System.out.println("toString - Koszyk - debug ");
        String iloscHerbaty = klient.name + ": ";
        if (koszykHerbatyKlienta.size() == 0) {
            iloscHerbaty += "--pusto";
        }
        for (var a :
                koszykHerbatyKlienta) {
            supermetoda.put(a.smak, a.waga);
            iloscHerbaty += "\n" + a.typ + ", smak: " + a.smak + ", ilość " + a.waga + " kg, cena " + a.cena;
        }
        return iloscHerbaty + "\n";
    }
}
