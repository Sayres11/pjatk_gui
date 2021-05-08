/*

package mypackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class save {
    static Samolot.nazwaSamolot[] samolot = new Samolot.nazwaSamolot[10];

    static public class Save {

        public Save() {
            int ran = 0;
            samolot[0] = new Samolot.nazwaSamolot("jakis tam samolet ", 1, 1, 1, "północ", 'a');
            samolot[1] = new Samolot.nazwaSamolot("Air force USA", 1, 1, 1, "północ", 'a');
            samolot[2] = new Samolot.nazwaSamolot("LOT", 1, 1, 1, "północ", 'a');
            samolot[3] = new Samolot.nazwaSamolot("Air France", 1, 1, 1, "północ", 'a');
            samolot[4] = new Samolot.nazwaSamolot("Saudia", 1, 1, 1, "północ", 'a');
            samolot[5] = new Samolot.nazwaSamolot("Hello,plane", 1, 1, 1, "północ", 'a');
            samolot[6] = new Samolot.nazwaSamolot("Delta Air Lines", 1, 1, 1, "północ", 'a');
            samolot[7] = new Samolot.nazwaSamolot("United States Air Force", 1, 1, 1, "północ", 'a');
            samolot[8] = new Samolot.nazwaSamolot("LOT", 1, 1, 1, "północ", 'a');
            samolot[9] = new Samolot.nazwaSamolot("Air Europe", 1, 1, 1, "północ", 'a');

            for (int i = 0; i < 10; i++) {
                //System.out.print(samolot[i].x + " ");
                //System.out.println(samolot[i].y);
                samolot[i].x = (int) (Math.random() * (10 + 1) + 1);
                samolot[i].y = (int) (Math.random() * (10 + 1) + 1);
                /////////////////////Prędkość/////////////////////////////////
                if (samolot[i].y < 4) samolot[i].prendkosc = (int) (Math.random() * (120 * 3) + 1);
                if (samolot[i].y > 6 && samolot[i].y < 8) samolot[i].prendkosc = (int) (Math.random() * (100 * 3));
                if (samolot[i].y > 8 && samolot[i].y < 11) samolot[i].prendkosc = (int) (Math.random() * (80 * 4));
                if (samolot[i].prendkosc < 70) samolot[i].prendkosc = (int) (Math.random() * (80 * 5));
                if (samolot[i].prendkosc < 70) samolot[i].prendkosc = (int) (Math.random() * (80 * 5));
                if (samolot[i].prendkosc < 70) samolot[i].prendkosc = (int) (Math.random() * (80 * 5));
                /////////////////////logs/////////////////////////////////
                System.out.print("Company:" + samolot[i].name + " ");
                System.out.print("x:" + samolot[i].x + " ");
                System.out.print("y:" + samolot[i].y + " ");
                System.out.print("Prędkość:" + samolot[i].prendkosc + " ");
                ///////////////////////Type///////////////////////////////
                ran = (int) (Math.random() * 150);
                if (ran < 25) samolot[i].Type = 'M';                         // millitary
                if (ran > 25 && ran <= 50) samolot[i].Type = 'S';            //          standart
                if (ran > 50 && ran <= 125) samolot[i].Type = 'B';           //          boeing
                if (ran > 125 && ran <= 150) samolot[i].Type = 'P';          //          sportowy
                if (samolot[i].Type == 'P') System.out.println("Sportowy");
                if (samolot[i].Type == 'M') System.out.println("Millitary");
                if (samolot[i].Type == 'B') System.out.println("Boeing");
                if (samolot[i].Type == 'S') System.out.println("standart");
                ////////////////////Odległość radaru///////////////////
                double d = Math.sqrt((samolot[i].x * samolot[i].x - 0) + (samolot[i].y * samolot[i].y) - 0);
                System.out.println("Odległość radaru:" + d + " ");
                System.out.println("---------");
                ////////////save///////////
                for (int j = 0; j < 10; j++) {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./test.txt"));
                        writer.newLine();
                        //writer.write(samolot[j].name + " " + samolot[j].x + " " + samolot[j].y + " " + samolot[j].prendkosc + " " + samolot[j].Type + "\n");
                        writer.write(samolot.toString()+ "\n");
                        writer.newLine();
                        writer.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

*/

