class Niebieska extends Herbata {

    public Niebieska(String smak, double waga) {
        super(smak, waga);
        this.smak = smak;
        this.waga = waga;
        typ = "Niebieska";

    }

    public String toString() {
        return "Niebieska herbata smak: " + smak + ", cenna: " + cena;
    }

}