class Zielona  extends Herbata  {


    public Zielona(String smak,double waga){
        super(smak, waga);
        this.smak = smak;
        this.waga = waga;
        typ = "Zielona";
    }

    public String toString() {
        return "Zielona herbata smak: " + smak + ", waga: " + waga;
    }

}