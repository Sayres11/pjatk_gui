package gui.z19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class gui extends JFrame {
    public gui() {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );

    }

    public void createGUI() {
        JFrame frame = new JFrame(LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear());

        JList<String> list = new JList<>(new ListModel());
        list.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1);

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(300, 200));

        frame.add(scroll);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
