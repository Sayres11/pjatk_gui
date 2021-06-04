package gui.z16;

import javax.swing.*;
import java.awt.*;


public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] buttonCaptions = new String[]{
                "Przycisk 1",
                "P 2",
                "Większy przycisk numer 3",
                "Przycisk 4",
                "P5"
        };

        String layout = JOptionPane.showInputDialog("Poprosze  podanie odpowiedniej litery (A-G)").toUpperCase();

        switch (layout) {
            case "A" -> frame.setLayout(new BorderLayout());
            case "B" -> frame.setLayout(new FlowLayout());
            case "C" -> frame.setLayout(new FlowLayout(FlowLayout.LEFT));
            case "D" -> frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
            case "E" -> frame.setLayout(new GridLayout(1, -1));
            case "F" -> frame.setLayout(new GridLayout(-1, 1));
            case "G" -> frame.setLayout(new GridLayout(3, 2));
            default -> JOptionPane.showMessageDialog(null, "Wpisano niewłaściwą literę.");
        }

        for (int i = 0; i < buttonCaptions.length; i++) {
            frame.add(new JButton(buttonCaptions[i]));
        }

      /*  JButton tmp = new JButton("Hello");
        tmp.addActionListener(e -> {
            tmp.setText("Hello gui");
        });
        frame.add(tmp);*/

        frame.pack();
        frame.setLocation(1920 / 2 - 100, 1080 / 2);
        frame.setVisible(true);
    }
}