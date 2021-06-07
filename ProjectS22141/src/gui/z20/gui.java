package gui.z20;

import gui.z19.ListModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class gui extends JFrame {
    public gui() {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );

    }

    public void createGUI() {
        JFrame frame = new JFrame("capitals");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
