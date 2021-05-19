package gui.w7.z15;
import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.green);
        textArea.append("Hello world");
        textArea.setForeground(Color.red);
        textArea.setFont(new Font("gui", Font.BOLD, 14));

        frame.setSize(300,300);
        frame.add(textArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
