package z18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;



public class menuBackground extends JRadioButtonMenuItem {
    public menuBackground(JTextArea textArea, Color color, String colorName) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> textArea.setBackground(color));

    }

    public menuBackground(JTextArea textArea, Color color, String colorName,status st,ButtonGroup group) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> st.setStatusColor(color));
        this.addActionListener((ActionEvent e) -> textArea.setBackground(color));
        group.add(menuBackground.this);
    }
}
