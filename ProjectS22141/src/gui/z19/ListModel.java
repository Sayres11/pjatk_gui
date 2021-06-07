package gui.z19;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class ListModel extends AbstractListModel implements javax.swing.ListModel {

    Locale lokalizacja = new Locale("PL");
    LocalDate dzis = LocalDate.now();
    LocalDate jakisDzien = LocalDate.of(dzis.getYear(), dzis.getDayOfMonth(), dzis.getMonthValue());

    @Override
    public int getSize() {
        return dzis.getMonth().length(dzis.isLeapYear());
    }

    @Override
    public Object getElementAt(int index) {
        return (index + 1) + " - " + jakisDzien.getDayOfWeek().plus(index).getDisplayName(TextStyle.FULL, lokalizacja);
    }
}
