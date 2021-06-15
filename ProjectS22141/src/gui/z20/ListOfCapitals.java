package gui.z20;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ListOfCapitals extends AbstractListModel<String> {

    ArrayList<String> list = new ArrayList<>();


    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public String getElementAt(int index) {
        return list.get(index);
    }

    public boolean add(String s) {
        if(s.isEmpty()){
            return false;
        }

        s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();

        String[] tokens = s.split(" ");
        if (tokens.length >= 2) {
            s = "";
            for (String l :
                    tokens) {
                s += l.substring(0, 1).toUpperCase() + l.substring(1).toLowerCase() + " ";
            }
            s = s.substring(0,s.length() - 1);
        }

        for (String l :
                list) {
            if (l.compareTo(s) == 0) return false;
        }
        list.add(s);
        list.sort(Comparator.naturalOrder());
        this.fireIntervalAdded(this, 0, getSize());
        return true;
    }

    boolean delete(int index) {
        if (list.size() == 0) {
            return false;
        }
        list.remove(index);
        this.fireIntervalRemoved(this, 0, getSize());
        return true;
    }

}
