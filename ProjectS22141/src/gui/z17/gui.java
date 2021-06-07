package gui.z17;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class gui extends JFrame {

    public gui() {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );

    }

    public static TextArea textArea;
    public static JTextField userField1;
    public static JTextField userField2;
    public static JTextField userField3;

    public void createGUI() {
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(1, 2));
        JPanel bottom = new JPanel(new GridLayout(1, 2));
        JPanel textFields = new JPanel(new GridLayout(3, 0));
        JPanel topBtRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel leftBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightBottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel gridNumber = new JPanel(new GridLayout(3, 3));

        mainPanel.add(top, BorderLayout.NORTH);
        mainPanel.add(bottom, BorderLayout.SOUTH);


        JPanel topBt = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jb1 = new JButton("FR");
        jb1.setBackground(Color.red);
        topBt.add(jb1);

        JButton jb2 = new JButton("FG");
        jb2.setBackground(Color.green);
        topBt.add(jb2);

        JButton jb3 = new JButton("FB");
        jb3.setBackground(Color.blue);
        topBt.add(jb3);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.red);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.green);
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.blue);
            }
        });

        topBtRight.add(new Button("A"));
        topBtRight.add(new Button("B"));
        topBtRight.add(new Button("C"));
        top.add(topBt);

        textArea = new TextArea("Obszar Tekstowy typu JTextArea" + "\n");

        JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        /*final JScrollPane scrollPane2 = new JScrollPane(textArea);
        mainPanel.add(scrollPane2, BorderLayout.EAST);*/

        java.util.List<JButton> NumberBt = new ArrayList<>(10);
        for (int i = 1; i <= 9; i++) {
            NumberBt.add(new JButton(String.valueOf(i)));
            gridNumber.add(NumberBt.get(i - 1));
        }

        userField1 = new JTextField("Pole tekstowe 1 typu JTextField");
        userField1.addActionListener(new InnerHandler());
        textFields.add(userField1);

        userField2 = new JTextField("Pole tekstowe 2 typu JTextField");
        userField2.addActionListener(new InnerHandler());
        textFields.add(userField2);

        userField3 = new JTextField("Pole tekstowe 3 typu JTextField");
        userField3.addActionListener(new InnerHandler());
        textFields.add(userField3);

        rightBottomPanel.add(textFields);
        leftBottomPanel.add(gridNumber);
        top.add(topBt);
        top.add(topBtRight);
        bottom.add(leftBottomPanel);
        bottom.add(rightBottomPanel);

        frame.setSize(500, 300);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class InnerHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField textField = (JTextField) e.getSource();
        Object source = e.getSource();
        if (gui.userField1.equals(source)) {
            gui.textArea.append("\n" + textField.getText() + "\n");
        } else if (gui.userField2.equals(source)) {
            gui.textArea.append("\n" + textField.getText() + "\n");
        } else {
            gui.textArea.append("\n" + textField.getText() + "\n");
        }
    }
}

class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

