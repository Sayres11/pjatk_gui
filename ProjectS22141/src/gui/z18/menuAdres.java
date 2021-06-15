package z18;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menuAdres extends menu {
    public menuAdres(String name, int key, JTextArea textArea, String text) {
        super(name, key, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK, (ActionEvent e) ->
                textArea.insert(text, textArea.getCaretPosition())
        );
    }
}
