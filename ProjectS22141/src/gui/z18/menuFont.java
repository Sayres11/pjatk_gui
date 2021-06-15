package z18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class menuFont extends JMenuItem {
    public menuFont(JTextArea textArea,status st,JLabel label, int i){
        super(i + " pts");
        Font font = textArea.getFont();
        setFont(font.deriveFont((float)i));
        this.addActionListener((ActionEvent e) -> {
            st.setFontSize(font);
            textArea.setFont(font.deriveFont((float)i));
            label.setText((String.valueOf(textArea.getFont().getSize())));
        });
    }
}
