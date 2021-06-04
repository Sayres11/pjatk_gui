package gui.w2;

import javax.management.ObjectName;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Spiewak> Spiewaki = new ArrayList<Spiewak>();

        Spiewak s4 = new Spiewak("Houston") {
            public String spiewaj() {
                return "a4iBBiii";
            }
        };
        Spiewak s5 = new Spiewak("Carrey") {
            public String spiewaj() {
                return "oaooooooooooo";
            }
        };
        Spiewak s6 = new Spiewak("Darrey") {
            public String spiewaj() {
                return "eeae";
            }
        };
        Spiewak s7 = new Spiewak("Darrey") {
            public String spiewaj() {
                return "bebe";
            }
        };
        Spiewak s8 = new Spiewak("Madonna") {
            public String spiewaj() {
                return "aAa";
            }
        };


        Spiewaki.add(s6);
        Spiewaki.add(s7);
        Spiewaki.add(s4);
        Spiewaki.add(s5);
        Spiewaki.add(s8);

        Collections.sort(Spiewaki);


        for (Spiewak s : Spiewaki)
            System.out.println(s);

        System.out.println("");
        Collections.reverse(Spiewaki);

        for (Spiewak s : Spiewaki)
            System.out.println(s);

    }

}

abstract class Spiewak implements Comparable<Spiewak> {
    private String name;
    private static int num = 1;
    private int count;

    public Spiewak(String name) {
        this.name = name;
        count = num++;
    }

    abstract String spiewaj();

    public String toString() {
        return "(" + count + ")" + name + ": " + spiewaj();
    }

    public int ilosc() {
        char[] c = this.spiewaj().toCharArray();
        int ile = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i] != c[j]) {
                    ile++;
                } else if (c[i] == c[j]) {
                    ile--;
                }
            }
        }
        return ile;
    }

    @Override
    public int compareTo(Spiewak o) {
         return o.toString().compareTo(o.toString());
        }
    }




