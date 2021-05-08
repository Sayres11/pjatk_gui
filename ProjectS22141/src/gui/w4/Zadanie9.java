package gui.w4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zadanie9 {
    public static void main(String[] args) {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        for (char z : napis)
            System.out.print(z + " ");

        System.out.println("");

        napis.ustawPoczatek(2);     // ustawienie początku iteracji (tu: 2-gi znak, o indeksie 2)
        napis.ustawKrok(3);         // ustawienie kroku iteracji (tu: co 3-ci znak)

        for (char z : napis)
            System.out.print(z + " ");
    }
}


    class IterNap implements Iterable<Character> {
        int ustawPoczatek;
        int ustawKrok;


        private final String inputString;


        public IterNap(String inputString) {
            this.inputString = inputString;
        }


        @Override
        public Iterator iterator() {
            return new ImplIterator();
        }
        public void ustawPoczatek(int ustawPoczatek){
            this.ustawPoczatek = ustawPoczatek;

        }
        public void ustawKrok(int ustawKrok){
            this.ustawKrok = ustawKrok;

        }


        private class ImplIterator implements Iterator<Character> {


        int current = 0;


            @Override
            public boolean hasNext() {
                if (current == inputString.length()) {
                    return false;
                }
                return true;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inputString.charAt(current++);
            }
        }
}