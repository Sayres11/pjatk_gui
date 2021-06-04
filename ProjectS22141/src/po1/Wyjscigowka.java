package po1;

public class Wyjscigowka extends Samochod {
    public Wyjscigowka arr[] = new Wyjscigowka[5];
    String opon;

    public Wyjscigowka(String silnik, int drzwi,String opon) {
        super(silnik, drzwi);
        this.opon = opon;
    }

    @Override
    public String toString() {
        return  opon;
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
}
