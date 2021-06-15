package gui.z19;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class ListModel extends AbstractListModel {

    Locale lokalizacja = new Locale("PL");
    LocalDate dzis = LocalDate.now();
    LocalDate jakisDzien = LocalDate.of(dzis.getYear(),  dzis.getMonthValue(),dzis.getDayOfMonth());

    @Override
    public int getSize() {
        return dzis.getMonth().length(dzis.isLeapYear());
    }

    @Override
    public Object getElementAt(int index ) {
        return (index + 1) + " - " +  jakisDzien.minusDays(LocalDate.now().getDayOfMonth()-1).plusDays(index).getDayOfWeek().getDisplayName(TextStyle.FULL, lokalizacja);
    }
}
