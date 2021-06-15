package z18;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class edytor extends JFrame {

    public edytor() {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );

    }

    private boolean fileLoaded;
    private JTextArea textArea = new JTextArea();
    private JFileChooser fileChooser;
    private final String[] FILTERS = {"txt", "txt file (*.txt)"};
    public static JLabel fileStatus;
    public static JLabel fontSizeStatus;

    private String name = "bez tytułu";


    public void createGUI() {
        JFrame frame = new JFrame("Prosty edytor - " + name);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        //FILE
        fileChooser = new JFileChooser(edytor.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath());

        JMenu file = new JMenu("File");

        file.add(new menu("Open", KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                name = fileChooser.getSelectedFile().getPath();
                load();
                frame.setTitle("Prosty edytor - " + fileChooser.getSelectedFile().getName());
            }
        }));

        file.add(new menu("Save", KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if (!fileLoaded) {
                if (fileChooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION)
                    return;
                name = fileChooser.getSelectedFile().getPath();
                frame.setTitle("Prosty edytor - " + fileChooser.getSelectedFile().getName());
                fileStatus.setText("saved");
            }
            this.save();
        }));

        file.add(new menu("Save as", KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> {
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                name = fileChooser.getSelectedFile().getPath();
                this.save();
                frame.setTitle("Prosty edytor - " + fileChooser.getSelectedFile().getName());
                fileStatus.setText("saved");
            }
        }));

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setBackground(Color.red);
        file.add(sep);

        file.add(new menu("Exit", KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK, (ActionEvent e) -> System.exit(0)));
        menuBar.add(file);


        //EDIT
        JMenu edit = new JMenu("Edit");
        JMenu adresy = new JMenu("Adresy");
        adresy.add(new menuAdres("Praca", KeyEvent.VK_P, textArea, "Secret"));
        adresy.add(new menuAdres("Dom", KeyEvent.VK_O, textArea, " Belarus,Minsk"));
        adresy.add(new menuAdres("Szkoła", KeyEvent.VK_S, textArea, " Poland,Warsaw, koszykowa 86"));


        //OPTIONS
        JMenu options = new JMenu("Options");
        JMenu foreground = new JMenu("Foreground");
        JMenu background = new JMenu("Background");

        //Color icon
        JMenu fontSize = new JMenu("Font size");

        JPanel status = new JPanel(new FlowLayout());
        Font font = textArea.getFont();
        status foregroundStatus = new status("fg");
        foregroundStatus.setStatusColor(Color.BLACK);
        status backgroundStatus = new status("bg");
        backgroundStatus.setStatusColor(Color.white);
        status.setLayout(new FlowLayout(FlowLayout.LEFT));
        status.add(foregroundStatus);
        status.add(backgroundStatus);
        fileStatus = new JLabel("new");
        fontSizeStatus = new JLabel("12");
        status.add(fontSizeStatus);
        status.add(fileStatus);
        options.add(fontSize);
        options.add(foreground);
        options.add(background);

        //COLOR
        HashMap<String, Color> colors = new HashMap<String, Color>();
        colors.put("GREEN", Color.GREEN);
        colors.put("ORANGE", Color.ORANGE);
        colors.put("RED", Color.RED);
        colors.put("BLACK", Color.BLACK);
        colors.put("WHITE", Color.WHITE);
        colors.put("YELLOW", Color.YELLOW);
        colors.put("BLUE", Color.BLUE);
        ButtonGroup foregroundGroup = new ButtonGroup();
        ButtonGroup backgroundGroup = new ButtonGroup();

        for (var a :
                colors.keySet()) {
            foreground.add(new menuForeground(textArea, colors.get(a), a, foregroundStatus, foregroundGroup));
            background.add(new menuBackground(textArea, colors.get(a), a, backgroundStatus, backgroundGroup));

        }


        //font size

        for (int i = 8; i < 26; i += 2) {
            fontSize.add(new menuFont(textArea, backgroundStatus,fontSizeStatus, i));

        }

        JScrollPane scrollPane = new JScrollPane(textArea);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(options);
        edit.add(adresy);
        frame.add(status, BorderLayout.SOUTH);

        frame.add(scrollPane);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fileStatus.setText("modified");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fileStatus.setText("modified");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fileStatus.setText("modified");
            }
        });
    }

    private void load() {
        try {
            this.textArea.setText(new String(Files.readAllBytes(Paths.get(this.name))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileLoaded = true;
    }

    private boolean save() {
        try {
            Files.write(Paths.get(this.name), this.textArea.getText().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

    }


}



