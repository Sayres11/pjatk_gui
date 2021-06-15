package z18;

import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class status extends JMenuItem {
   private String fontSize;



    public status(String name) {
        super(name);
    }

    public void setFontSize(Font font) {
        fontSize = String.valueOf(font.getSize());
    }

    public void setStatusColor(Color color) {
        setIcon(new ColorIcon(color));
    }




}
