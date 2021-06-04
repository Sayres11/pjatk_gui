package po1;

public class Samochod<T> {
    public Samochod arr[] = new Samochod[5];

    int count = 0;
    public String silnik;
    public int drzwi;
    int numer = 0;

    public Samochod(String silnik, int drzwi) {
        this.silnik = silnik;
        this.drzwi = drzwi;
        numer++;
    }

    public void porownuj() {
        for (int i = 0; i > arr.length; i++) {
            if (arr[0].silnik == arr[i].silnik) {
                System.out.println("silnik == ");
                if (arr[0].drzwi == arr[i].drzwi) {
                    System.out.println("dzwi ==");
                    if (arr[0].numer == arr[i].numer) {
                    }
                }
            } else {
                System.out.println("not");
            }

        }
    }

    public void add(T t) {
        if (arr.length != 4) {
            arr[count++] = (Samochod) t;
        }
    }
 /*   public String compareTo(Samochod o){
        if(silnik.compareTo(o.silnik) < 0){
            return  -1;
        }
    }*/


    @Override
    public String toString() {
        return silnik + " " + drzwi + " " + numer;
    }
}
