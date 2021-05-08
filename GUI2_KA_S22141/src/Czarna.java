class Czarna extends Herbata {


    public Czarna(String smak, double waga) {
        super(smak, waga);
        this.smak = smak;
        this.waga = waga;
        typ = "Czarna";
    }

    public String toString() {
        return "Czarna herbata smak: " + smak + ", cena: " + cena;
    }


}