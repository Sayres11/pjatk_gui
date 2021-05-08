package gui.w3.z1;

interface Flyable {
    public String drive();

    public double distance();

   public static Flyable minDistance(Flyable[] flyObj) {
        Flyable min = flyObj[0];
        for (int i = 0; i < flyObj.length; i++) {
            if (min.distance() > flyObj[i].distance()) {
                min = flyObj[i];
            }

        }
        return min;
    }
}

interface Speakable {
    public String speak();

    public static Speakable Najglosniejszy(Speakable[] speakObj) {
        int maxCounter = 0;
        int tempCounter = 0;
        Speakable max = speakObj[0];
        for (int j = 0; j < speakObj.length; j++) {
            char[] charArray = speakObj[j].speak().toCharArray();
            for (int i = 0; i < charArray.length - 1; i++) {

                if (charArray[i] != charArray[i + 1]) {
                    tempCounter++;
                }
            }
            if (tempCounter > maxCounter) {
                max = speakObj[j];
                maxCounter = tempCounter;
                tempCounter = 0;
            }
        }
        return max;
    }
}


class Bird implements Flyable, Speakable {
    private String naped;
    private double odleglosc;
    private String odglos;

    public Bird(String naped,double odleglosc)
    {

        this.odleglosc = odleglosc;
        this.naped = naped;
    }
    @Override
    public String drive() {
        return this.naped;
    }

    @Override
    public double distance() {
        return this.odleglosc;
    }

    @Override
    public String speak() {
        return this.odglos;
    }
    public String toString()
    {
        return "Napęd: " + this.naped + ", odleglosc: " + this.odleglosc + ", odglos: " + speak();
    }
}


class Plane implements Flyable, Speakable {
    private String naped;
    private double odleglosc;
    private String odglos;

    public Plane(String naped,double odleglosc)
    {
        this.odleglosc = odleglosc;
        this.naped = naped;
    }
    @Override
    public String drive() {
        return this.naped;
    }

    @Override
    public double distance() {
        return this.odleglosc;
    }

    @Override
    public String speak() {
        return this.odglos;
    }
    public String toString()

    {
        return "Napęd: " + this.naped + ", odleglosc: " + this.odleglosc + ", odglos: " + speak();
    }

}

class UFO implements Flyable, Speakable {

    private String naped;
    private double odleglosc;
    private String odglos;

    public UFO(String naped,double odleglosc)
    {
        this.odleglosc = odleglosc;
        this.naped = naped;
    }
    @Override
    public String drive() {
        return this.naped;
    }

    @Override
    public double distance() {
        return this.odleglosc;
    }

    @Override
    public String speak() {
        return this.odglos;
    }
    public String toString()

    {
        return "Napęd: " + this.naped + ", odleglosc: " + this.odleglosc;
    }
}

abstract class Virus implements Flyable, Speakable {

    private String naped;
    private double odleglosc;
    private String odglos;

    public Virus(String naped,double odleglosc)
    {
        this.odleglosc = odleglosc;
        this.naped = naped;
    }
    @Override
    public String drive() {
        return this.naped;
    }

    @Override
    public double distance() {
        return this.odleglosc;
    }

    @Override
    public String speak() {
        return this.odglos;
    }
    public String toString()

    {
        return "Napęd: " + this.naped + ", odleglosc: " + odleglosc;
    }
}

class dds{
    public static void main(String[] args) {
        Bird bird = new Bird("Bird",100) {
            public String speak() { return "a4iBBiii"; }
        };
        Plane plane = new Plane("Plane",1200){
            public String speak() { return "DssDss13";}
        };
        UFO ufo = new UFO("UFO",10000){
        };
        Virus virus = new Virus("Virus",800){
        };
        Flyable fl [] = {bird, plane, ufo,virus};
        Speakable sp [] = {bird,plane};

        for (Flyable s : fl)
            System.out.println(s);

        System.out.println("\n" + Flyable.minDistance(fl));
        System.out.println("\n" + Speakable.Najglosniejszy(sp));


    }
}