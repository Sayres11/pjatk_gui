package gui.z17;

import java.awt.*;

import javax.swing.*;


public class gui extends JFrame {
    public static void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setText("text");
        textArea.setPreferredSize(new Dimension(600, 400));
        mainPanel.add(textArea,BorderLayout.CENTER);

        final JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        final JScrollPane scrollPane2 = new JScrollPane(textArea);
        mainPanel.add(scrollPane2, BorderLayout.EAST);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        mainPanel.add(panel, BorderLayout.CENTER);

        JPanel panelCyfr = new JPanel();
        panelCyfr.setLayout(new GridLayout(2, 3, 2, 2));

        JPanel text = new JPanel();
        text.setLayout(new GridLayout(3,1,2,2));

        JTextField jtextField = new JTextField("pole tekstowe 1");
        text.add(jtextField);

        JTextField jtextField2 = new JTextField("pole tekstowe 2");
        text.add(jtextField2);


        JTextField jtextField3 = new JTextField("pole tekstowe 3");
        text.add(jtextField3);
        mainPanel.add(text, BorderLayout.SOUTH);

        JButton jb1 = new JButton("1");
        panelCyfr.add(jb1);


        JButton jb2 = new JButton("2");
        panelCyfr.add(jb2);


        JButton jb3 = new JButton("3");
        panelCyfr.add(jb3);
        mainPanel.add(panelCyfr,BorderLayout.NORTH);

frame.setSize(800,600);
        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(350, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
