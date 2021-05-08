package gui.w5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayBox<Osoba> bo = new ArrayBox<>(2);

        bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
        bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
        bo.add(new Student("Kowalska", 20, 200));
        Osoba[] to = new Osoba[]{new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
        bo.addAll(to);

        System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));

        System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<>(2);
        Integer[] ti = new Integer[]{Integer.valueOf(1), 2, 3};
        bi.addAll(ti);

        bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<>(1);
        String[] ts = new String[]{"cpp", new String("java")};
        bs.addAll(ts);
        bs.swap(0, 1);
        bs.print();// java, cpp
      /*  int a = bs.search("cpp");
        System.out.println(a);
        bs.delete(1);
        bs.print();*/

    }
}

class ArrayBox<T extends Comparable> {

    Object[] arr;
    public int size = 0;


    public ArrayBox(int arrayLength) {

        arr = new Object[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = new Object();
        }
    }

    public ArrayBox() {
        int default_size = 10;
        arr = new Object[default_size];
    }


    public boolean addAll(T[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (arr[i] != null && arr[i].equals(ar[i])) {
                return false;
            }
            if (size + 1 == arr.length || size == arr.length) {
                addLenght(ar.length);
                arr[size] = ar[i];
                size++;
            } else {
                arr[size] = ar[i];
                size++;
            }
        }
        return false;
    }

    public boolean add(T t) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(t)) {
                return false;
            }
        }
        if (size + 1 == arr.length || size == arr.length) {
            addLenght(1);
        }
        arr[size] = t;
        size++;
        return true;
    }


    boolean delete(int index) {
        for (int i = (int) index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        return true;
    }

    boolean swap(int a1, int b1) {
        if (a1 != b1 || a1 >= size && b1 <= size) {
            Object[] bufArr = new Object[2];
            bufArr[0] = arr[a1];
            bufArr[1] = arr[b1];
            arr[a1] = bufArr[1];
            arr[b1] = bufArr[0];
            return true;
        } else {
            return false;
        }
    }


    public T min() {
        T min = (T) arr[0];
        for (int i = 0; i < size; i++) {
            if (((T) arr[i]).compareTo(min) < 0) {
                min = ((T) arr[i]);
            }
        }
        return min;
    }


    public T max() {
        T max = (T) arr[0];
        for (int i = 0; i < size; i++) {
            if (((T) arr[i]).compareTo(max) > 0) {
                max = ((T) arr[i]);
            }
        }
        return max;
    }


    public int search(T nr) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(nr))
                return i;
        }
        return -1;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public int size() {
        return size;
    }

    public void addLenght(int a) {
        arr = Arrays.copyOf(arr, arr.length + a);
    }


}


class Osoba implements Comparable<Osoba> {
    String nazwisko;
    int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    // porównujemy 2 obiekty this, o
    // można korzystać z compareTo(...) z klasy String
    public int compareTo(Osoba o) {
        if (nazwisko.compareTo(o.nazwisko) < 0) {
            return -1;
        } else {
            if (nazwisko.compareTo(o.nazwisko) > 0) {
                return 1;
            } else {
                if ((this.wiek - o.wiek) < 0) {
                    return this.wiek - o.wiek;
                } else {
                    if ((this.wiek - o.wiek) > 0) {
                        return this.wiek - o.wiek;
                    }
                    return 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Osoba nazwisko: " + nazwisko + ", Wiek: " + wiek + "\n";
    }
}


class Student extends Osoba {
    int numerGrupy;

    public Student(String nazwisko, int wiek, int numerGrupy) {
        super(nazwisko, wiek);
        this.numerGrupy = numerGrupy;
    }


    public int compareTo(Osoba o) {
        if (this.nazwisko.compareTo(o.nazwisko) < 0) {
            return -1;
        } else {
            if (this.nazwisko.compareTo(o.nazwisko) > 0) {
                return 1;
            } else {
                if (this.wiek - o.wiek < 0) {
                    return -1;
                } else {
                    if (this.wiek - o.wiek > 0) {
                        return 1;
                    } else {
                        if (o instanceof Student) {
                            Student s = (Student) o;
                            if (this.numerGrupy - s.numerGrupy < 0) {
                                return -1;
                            } else {
                                if (this.numerGrupy - s.numerGrupy > 0) {
                                    return 1;
                                } else return 0;
                            }
                        } else return 0;
                    }

                }
            }
        }
    }


    public String toString() {
        return super.toString() + "Student: " + nazwisko + ", numer grupy: " + numerGrupy + "\n";
    }
}


