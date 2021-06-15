package z18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class menuForeground extends JRadioButtonMenuItem {
    public menuForeground(JTextArea textArea, Color color, String colorName,status status,ButtonGroup group) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> textArea.setForeground(color));
        this.addActionListener((ActionEvent e) -> status.setStatusColor(color));
        group.add(menuForeground.this);
    }

    public menuForeground(JTextArea textArea, Color color, String colorName) {
        super(colorName);
        this.setIcon(new ColorIcon(color));
        this.addActionListener((ActionEvent e) -> textArea.setForeground(color));
    }
}
