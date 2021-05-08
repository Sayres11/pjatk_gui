import java.util.Collections;

public class Klient<T extends Herbata> {
    String name;
    double money;
    Cennik cennik = Cennik.pobierzCennik();

    Koszyk ks;
    ListaZakupow listaZakupow = new ListaZakupow(this);

    public Klient(String name, double money) {
        this.name = name;
        this.money = money;
    }


    public String toString() {
        return "Name: " + name + ", Money: " + money;
    }

    public void dodaj(T t) {
        listaZakupow.herbataKlienta.add((Herbata) t);
        subclass.supermetoda.put(((Herbata) t).smak, ((Herbata) t).waga);
    }

    public ListaZakupow pobierzListeZakupow() {
        return listaZakupow;
    }

    public void przepakuj(Koszyk ks) {
        this.ks = ks;

        for (int i = 0; i < listaZakupow.herbataKlienta.size(); i++) {
            if (listaZakupow.herbataKlienta.get(i).cena > 0) {
                ks.koszykHerbatyKlienta.add(listaZakupow.herbataKlienta.get(i));
                listaZakupow.herbataKlienta.remove(i);
                i--;
                //ks.koszykHerbatyKlienta = listaZakupow.herbataKlienta.get(i);
            }
        }
    }


    public void zaplac(String platnosc) {
        double sum = 0;
        int i = 0;
        for (var a :
                ks.koszykHerbatyKlienta) {
            sum = sum + (a.cena * a.waga);
        }
        if (money - sum < 0) {
            //System.out.println("zaplac -  klient dont have money - debug");
            sum = 0;
            int counter = 1;
            Collections.reverse(ks.koszykHerbatyKlienta);
            for (int j = 0; j < ks.koszykHerbatyKlienta.size(); j++) {
                if (ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga < money) {
                    money -= ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga;
                    sum = sum + ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga;
                    ks.koszykHerbatyKlienta.remove(j);
                    j--;
                } else {
                    for (int b = 0; b < 2; b++) {
                        if (ks.koszykHerbatyKlienta.get(j).waga == 0) {
                            continue;
                        }
                        if (ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga > money) {
                            counter++;
                            b = 0;
                            ks.koszykHerbatyKlienta.get(j).waga -= 0.5;
                        } else {
                            money -= ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga;
                            sum = sum + ks.koszykHerbatyKlienta.get(j).cena * ks.koszykHerbatyKlienta.get(j).waga;
                        }
                    }
                }
            }
        } else {
            ks.koszykHerbatyKlienta.clear();
            //System.out.println("zaplac - koszyk clear - debug");
        }
        if (platnosc == "karta") {
            //System.out.println(sum+"sum");
            double prowizja = sum / 100;
            //System.out.println(prowizja+ "d");
            money -= prowizja;
        } else {
            money -= sum;
        }
    }


    public double pobierzPortfel() {
        return money;
    }

    public Koszyk pobierzKoszyk() {
        return this.ks;
    }
}

