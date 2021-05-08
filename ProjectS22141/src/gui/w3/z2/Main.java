package gui.w3.z2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Figura> Fig = new ArrayList<Figura>();

        Figura[] fig = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
        fig[1] = new Prostokat(20, 20, 15, 10);
        Prostokat2 p2 = new Prostokat2(20, 20, 10, 5, '*');// położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10

        Fig.add(fig[0]);
        Fig.add(fig[1]);
        Fig.add(p2);

        System.out.println("Figury przed sortowaniem:");

        for (Figura i: Fig)
            System.out.println(i);

        Collections.sort(Fig);
        System.out.println("Po sortowaniem");
        for (Figura i: Fig)
        System.out.println(i);


        for (Figura f : fig)              // pętla for-each
            System.out.println(f);

        fig[0].pozycja(12, 12);
        fig[0].obliczenie();
        fig[1].pozycja(25, 30);
        fig[1].obliczenie();
        p2.rysuj();

        Kolo2 k2 = new Kolo2(15, 20, 5);

        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
        System.out.println(k2);
    }
}

interface Obliczenie {

    void obliczenie();
}

interface Rysowanie {
    void rysuj();
}

interface Transformacja {
    void przesunDo(int x, int y);

    void powrot();
}


abstract class Figura implements Obliczenie, Comparable<Figura> {
    int a, b, a1, b1;

    public Figura(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract String Nazwa();

    public abstract void pozycja(int a1, int b1);

    public abstract String toString();

/*    @Override
    public int compareTo(Figura f)
    {
        // obiekty: this, f
        // obiekt1.compareTo(obiekt2)

        if (this.pole() - f.pole() < 0)
            return -1;	// < 0
        else if (this.pole() - f.pole() > 0)
            return 1; 	// > 0
        else {

        }
        return 0;
    }

    protected abstract void pole();

}*/
}


class Kolo extends Figura implements Obliczenie {
    private int prom;


    public Kolo(int a, int b, int prom) {
        super(a, b);
        this.prom = prom;

    }

    @Override
    public String Nazwa() {
        return "Kolo";
    }

    @Override
    public void pozycja(int a1, int b1) {
        double odleglosc = Math.sqrt(((a - a1) * (a - a1)) + (((b - b1) * (b - b1))));
        if (odleglosc < prom) {
            System.out.println("\nPunkt" + " (" + a1 + "," + b1 + ")" + " znajduje się wewnątrz koła");
        } else {
            System.out.println("\nPunkt" + " (" + a1 + "," + b1 + ")" + " znajduje się zewewnątrz koła");
        }
    }


    @Override
    public String toString() {
        return Nazwa() + "\nŚrodek - (" + a + "," + b + ")\n" + "Promień - " + prom + "\n";
    }

    @Override
    public void obliczenie() {
        double pi = 3.1415;
        double p = pi * prom;
        System.out.println("Obwod kola: " + p + "\n");
    }

    @Override
    public int compareTo(Figura o) {
        return 0;
    }
}



class Prostokat extends Figura implements Obliczenie {
    int szerok, wysok;

    public Prostokat(int a, int b, int szerok, int wysok) {
        super(a, b);
        this.szerok = szerok;
        this.wysok = wysok;

    }

    @Override
    public String Nazwa() {
        return "Prostokat";
    }

    @Override
    public void pozycja(int a1, int b1) {
        double d = (a - b) * (b1 - b) - (a1 - a) * (b1 - b);
        if (d > 0 || d < 0 || d == 0) {
            System.out.println("\nPunkt" + " (" + a1 + "," + b1 + ")" + " znajduje się zewewnątrz koła");
        } else {
            System.out.println("\nPunkt" + " (" + a1 + "," + b1 + ")" + " znajduje się wewnątrz koła");

        }
    }


    @Override
    public String toString() {
        return "\n" + Nazwa() + "\n" + "Lewy górny - (" + a + "," + b + ")\n" + "Szerokość: " + szerok + " Wysokość: " + wysok;
    }

    @Override
    public void obliczenie() {
        int p = (2 * a) + (2 * b);
        System.out.println("Obwód prostokąta: " + p + "\n");
    }

    @Override
    public int compareTo(Figura o) {
        return 0;
    }
}


class Prostokat2 extends Prostokat implements Rysowanie {
    char ch;

    public Prostokat2(int a, int b, int szerok, int wysok, char ch) {
        super(a, b, szerok, wysok);
        this.ch = ch;
    }

    @Override
    public void rysuj() {
        for (int i = 0; i < wysok; i++) {
            for (int j = 0; j < szerok; j++) {
                System.out.print(ch);
            }
            System.out.println();

        }
        System.out.println();
    }
}

class Kolo2 extends Kolo implements Transformacja {
    int temp[] = new int[2];

    public Kolo2(int a, int b, int prom) {
        super(a, b, prom);
    }

    @Override
    public void przesunDo(int x, int y) {
        temp[0] = a;
        temp[1] = b;
        a = x;
        b = y;
    }

    @Override
    public void powrot() {
        a = temp[0];
        b = temp[1];
    }
}



