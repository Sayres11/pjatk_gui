package z18;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menu  extends JMenuItem {
    public menu(String name, int key, int modifier, ActionListener onPress){
        super(name);
        this.setAccelerator(KeyStroke.getKeyStroke(key, modifier, false));
        this.addActionListener(onPress);

    }
}
