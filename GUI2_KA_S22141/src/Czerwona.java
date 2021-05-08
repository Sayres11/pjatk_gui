class Czerwona extends Herbata {

    public Czerwona(String smak, double waga) {
        super(smak, waga);
        this.smak = smak;
        this.waga = waga;
        typ = "Czerwona";
    }

    public String toString() {
        return "Czerwona herbata smak: " + smak + ", cena: " + cena;
    }


}