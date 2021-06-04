package ExpertSoft;

import java.util.*;

class newList {
    void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        a.addAll(b);
        Integer temp;
        if (a.size() > 1) {
            for (int x = 0; x < a.size(); x++) {
                for (int i = 0; i < a.size() - x - 1; i++) {
                    if (a.get(i) > (a.get(i + 1))) {
                        temp = a.get(i);
                        a.set(i, a.get(i + 1));
                        a.set(i + 1, temp);
                    }
                }
            }
        }
    }
}


public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> firstArray = new ArrayList<>();


        firstArray.add(1);
        firstArray.add(3);
        firstArray.add(5);

        ArrayList<Integer> secondArray = new ArrayList<>();
        secondArray.add(2);
        secondArray.add(6);
        secondArray.add(8);

        for (int i = 1500; i > 0; i--) {
            secondArray.add(i);
        }
        for (int i = 2500; i < 5000; i++) {
            firstArray.add(i);
        }
        newList listik = new newList();
        listik.merge(firstArray, secondArray);
        for (int i = 0; i < firstArray.size(); i++) {
            System.out.println(firstArray.get(i));
        }
    }
}
