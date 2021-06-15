package gui.z20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui extends JFrame {
    public gui() {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );

    }

    JTextField SearchField;
    private final String errorMessage = "ERROR MESSAGE";

    public void createGUI() {
        JFrame frame = new JFrame("Capitals");
        JPanel main = new JPanel(new BorderLayout());
        ListOfCapitals listOfCapitals = new ListOfCapitals();
        JList<String> list = new JList<>(listOfCapitals);
        listOfCapitals.add("Warsaw");
        listOfCapitals.add("Tokio");
        listOfCapitals.add("Moscow");
        listOfCapitals.add("London");
        list.setSelectionForeground(Color.red);
        list.setSelectionBackground(Color.yellow);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (listOfCapitals.getSize() == 0) {
                        JOptionPane.showMessageDialog(gui.this,
                                new String[]{"ERROR 01",
                                        " - Capitals is empty"},
                                errorMessage,
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        listOfCapitals.delete(list.getSelectedIndex());
                    }
                } else {
                    if (listOfCapitals.getSize() == 0) {
                        JOptionPane.showMessageDialog(gui.this,
                                new String[]{"ERROR 01",
                                        " - Capitals is empty"},
                                errorMessage,
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println(listOfCapitals.getElementAt(list.getSelectedIndex()));
                    }
                }
            }
        });


        SearchField = new JTextField();
        //SearchField.setBounds(0, 0, 200, 30);
        SearchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listOfCapitals.add(SearchField.getText())) {
                    JOptionPane.showMessageDialog(gui.this,
                            new String[]{"ERROR 02",
                                    " - such a capital is already on the list or field is empty"},
                            errorMessage,
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(!SearchField.getText().isEmpty()) {
                    listOfCapitals.add(SearchField.getText());
                }
            }
        });


        JScrollPane scroll = new JScrollPane(list);

        main.add(SearchField, BorderLayout.NORTH);
        main.add(scroll, BorderLayout.CENTER);

        frame.add(main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
