package mypackage;

import java.io.*;

public class S22141 {

    public static void main(String[] args) throws IOException {
        Samolot[][] samolot = new Samolot[41][2];
        double[] d = new double[41];

        samolot[0][0] = new Wojskowy("SECRET", 1, 1, 7, 1, "Wschód", true);
        samolot[1][0] = new Wojskowy("Air force USA", 25, 8, 15, 450, "północ", true);
        samolot[2][0] = new Wojskowy("Air force Poland", 33, 8, 13, 400, "Południowy", false);
        samolot[3][0] = new Wojskowy("Air force British", 27, 53, 130, 420, "północ", false);
        samolot[4][0] = new Wojskowy("Air force Japane", 7, 11, 200, 300, "północ", true);
        samolot[5][0] = new Wojskowy("Air force Spain", 5, 4, 10, 400, "Zachód", false);
        samolot[6][0] = new Wojskowy("Air force USA", 5, 4, 10, 420, "północ", true);
        samolot[7][0] = new Wojskowy("jakis tam samolot ", 1, 1, 7, 1, "Południowy", true);
        samolot[8][0] = new Wojskowy("Air force USA", 25, 8, 15, 159, "Południowy", true);
        samolot[9][0] = new Wojskowy("Air force USA", 33, 8, 13, 159, "północ", false);
        samolot[10][0] = new Transportowy("Cargo", 27, 53, 130, 132, "Wschód", 300);
        samolot[11][0] = new Transportowy("DHL", 7, 11, 200, 513, "północ", 250);
        samolot[12][0] = new Transportowy("DHL", 5, 4, 10, 123, "Południowy", 600);
        samolot[13][0] = new Transportowy("DHL", 5, 4, 10, 231, "Południowy", 500);
        samolot[14][0] = new Transportowy("jakis tam samolot ", 1, 1, 312, 1, "północ", 200);
        samolot[15][0] = new Transportowy("DHL", 25, 8, 15, 132, "północ", 300);
        samolot[16][0] = new Transportowy("Poczta", 33, 8, 13, 542, "północ", 400);
        samolot[17][0] = new Transportowy("Poczta EURO", 27, 53, 130, 376, "północ", 300);
        samolot[18][0] = new Transportowy("Poczta Spain", 7, 11, 200, 167, "Zachód", 500);
        samolot[19][0] = new Transportowy("Cargo", 5, 4, 10, 159, "Zachód", 200);
        samolot[20][0] = new Transportowy("Air force USA", 5, 4, 10, 256, "północ", 76);
        samolot[21][0] = new Boeing("Fly Emirates", 1, 1, 7, 200, "Południowy", 300);
        samolot[22][0] = new Boeing("LOT", 25, 8, 15, 159, "Południowy", 200);
        samolot[23][0] = new Boeing("Belavia", 33, 8, 13, 245, "Wschód", 400);
        samolot[24][0] = new Boeing("FedEx", 27, 53, 130, 345, "Zachód", 300);
        samolot[25][0] = new Boeing("Fly one", 7, 11, 200, 177, "północ", 400);
        samolot[26][0] = new Boeing("Ryanair", 5, 4, 10, 159, "północ", 220);
        samolot[27][0] = new Boeing("LOT", 5, 4, 10, 244, "Południowy", 500);
        samolot[28][0] = new Boeing("LOT", 25, 8, 15, 276, "Południowy", 200);
        samolot[29][0] = new Boeing("Fly Emirates", 33, 8, 13, 341, "północ", 400);
        samolot[30][0] = new Boeing("FedEx", 27, 53, 130, 159, "północ", 300);
        samolot[31][0] = new Boeing("Fly Emirates", 1, 1, 7, 1, "północ", 300);
        samolot[32][0] = new Strażacki("LOT", 25, 8, 15, 159, "Południowy", 200);
        samolot[33][0] = new Strażacki("Strażacki", 33, 8, 13, 159, "północ", 400);
        samolot[34][0] = new Strażacki("Strażacki", 27, 53, 130, 159, "Wschód", 300);
        samolot[35][0] = new Strażacki("Strażacki", 7, 11, 200, 555, "Zachód", 400);
        samolot[36][0] = new Strażacki("Strażacki", 5, 4, 10, 422, "północ", 220);
        samolot[37][0] = new Strażacki("Strażacki", 5, 4, 10, 323, "Południowy", 500);
        samolot[38][0] = new Strażacki("Strażacki", 25, 8, 15, 234, "północ", 200);
        samolot[39][0] = new Strażacki("Strażacki", 33, 8, 13, 432, "Wschód", 400);
        samolot[40][0] = new Strażacki("Strażacki", 27, 53, 130, 234, "północ", 300);

        if (args[0].equals("save")) {


            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("./test.txt"));
                for (int j = 0; j < samolot.length; j++) {
                    writer.write(samolot[j][0].toString() + "\n");
                }
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (args[0].equals("load")) {
            for (int i = 0; i < samolot.length; i++) {
                samolot[i][0].x = (int) (Math.random() * (45 + 1) + 1);
                samolot[i][0].y = (int) (Math.random() * (45 + 1) + 1);
                samolot[i][0].z = (int) (Math.random() * (45 + 1) + 1);

            }

            char[] readed = new char[5000];
            FileReader read = new FileReader("./test.txt");
            read.read(readed);
            System.out.println("Data in the file: ");
            System.out.println(readed);
            read.close();

            for (int i = 0; i < samolot.length; i++) {
                System.out.print("Company:" + samolot[i][0].name + " ");
                System.out.print("x:" + samolot[i][0].x + " ");
                System.out.print("y:" + samolot[i][0].y + " ");
                System.out.print("z:" + samolot[i][0].z + " ");
                System.out.println("Prędkość:" + samolot[i][0].prendkosc + " ");
                d[i] = Math.sqrt((samolot[i][0].x * samolot[i][0].x - 0) + (samolot[i][0].y * samolot[i][0].y - 0) + (samolot[i][0].z * samolot[i][0].z - 0));
                System.out.println("Odległość radaru:" + d[i] + " ");
                System.out.println("---------");
            }

            for (int i = 0; i < d.length - 1; i++) {
                for (int j = 0; j < d.length - i - 1; j++) {
                    if (d[j] > d[j + 1]) {
                        double temp = d[j];
                        d[j] = d[j + 1];
                        d[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i]);
            }

        }
    }
}


class Samolot {
    protected String name;
    protected int x, y, z, prendkosc;
    protected String wektor;

    public Samolot(String name, int x, int y, int z, int prendkosc, String wektor) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.prendkosc = prendkosc;
        this.wektor = wektor;
    }

    public String toString() {
        return this.name + ", " + this.x + ",  " + this.y + ", " + this.z + ", " + this.wektor + ", " + this.prendkosc;
    }
}

class Wojskowy extends Samolot {
    protected boolean uzbrojony;

    public Wojskowy(String name, int x, int y, int z, int prendkosc, String wektor, boolean uzbrojony) {
        super(name, x, y, z, prendkosc, wektor);
        this.uzbrojony = uzbrojony;
    }

    public String toString() {
        return super.toString() + " " + this.uzbrojony;
    }
}

class Boeing extends Samolot {
    protected int pojemność;

    public Boeing(String name, int x, int y, int z, int prendkosc, String wektor, int pojemność) {
        super(name, x, y, z, prendkosc, wektor);
        this.pojemność = pojemność;


    }

    public String toString() {
        return super.toString() + " " + this.pojemność;
    }
}

class Transportowy extends Samolot {
    protected int wagaprzewozu;

    public Transportowy(String name, int x, int y, int z, int prendkosc, String wektor, int wagaprzewozu) {
        super(name, x, y, z, prendkosc, wektor);
        this.wagaprzewozu = wagaprzewozu;

    }

    public String toString() {
        return super.toString() + " " + this.wagaprzewozu;
    }
}

class Strażacki extends Samolot {
    protected int wagaWody;

    public Strażacki(String name, int x, int y, int z, int prendkosc, String wektor, int wagaWody) {
        super(name, x, y, z, prendkosc, wektor);
        this.wagaWody = wagaWody;
    }

    public String toString() {
        return super.toString() + " " + this.wagaWody;
    }

}


