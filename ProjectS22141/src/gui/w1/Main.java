package gui.w1;

public class Main {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Dietrich") {
            public String spiewaj() {
                return "oooooooooooo";
            }
        };

        Spiewak s2 = new Spiewak("Piaf") {
            public String spiewaj() {
                return "a4iBBiii";
            }
        };


        Spiewak s3 = new Spiewak("Adele") {
            public String spiewaj() {
                return "aAa";
            }
        };


        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);


        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}

abstract class Spiewak {
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


    static Spiewak najglosniej(Spiewak[] tab) {
        Spiewak max = tab[0];
        for (Spiewak s : tab) {
            if (max.ilosc() < s.ilosc()) {
                max = s;
            }
        }
        return max;
    }
}



