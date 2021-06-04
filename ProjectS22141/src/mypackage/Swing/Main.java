package mypackage.Swing;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.ThreadFactory;

public class Main {

    public static void main(String[] args) {

        JFrame jf = new JFrame("BALLOONS");
        jf.setSize(1000, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<Factory> listOfFact = new ArrayList<>();
        ArrayList<Thread> listFacTh = new ArrayList<>();
        ArrayList<Transporter> listOfTrans = new ArrayList<>();

        int[] arr = {0, 0};


        JComboBox<String> cbOfFactories = new JComboBox<>();


        JComboBox<String> cbOfTrans = new JComboBox<>();


        JButton addFact = new JButton("Add factory");


        addFact.addActionListener(e -> {
            Factory tmp = new Factory();
            Thread tg = new Thread(tmp);
            tg.start();
            tg.setName(Integer.toString(arr[0]++));
            listFacTh.add(tg);
            listOfFact.add(tmp);
//            tmp.start();
//            tmp.setName(Integer.toString(arr[0]++));
            cbOfFactories.addItem("Factory # " + tg.getName());
        });


        JButton addTrans = new JButton("Add transporter");

        addTrans.addActionListener(
                e -> {
                    Transporter tmp = new Transporter();
                    listOfTrans.add(tmp);
                    listOfTrans.get(arr[1]).start();
                    tmp.setName(Integer.toString(arr[1]++));
                    cbOfTrans.addItem("Transporter # " + tmp.getName());
                });


        JButton delFact = new JButton("Delete factory");
        JButton pauseFact = new JButton("Pause factory");
        JButton resumeFact = new JButton("Resume factory");


        cbOfFactories.addActionListener(e -> {
            GridBagLayout grigBag = new GridBagLayout();
            GridBagConstraints zae = new GridBagConstraints();
            JFrame facTmp = new JFrame("Factory #" + cbOfFactories.getSelectedIndex());
            JPanel slider = new JPanel();
            slider.setLayout(grigBag);
            facTmp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            JSlider timeForBal = listOfFact.get(cbOfFactories.getSelectedIndex()).getJs();
            timeForBal.setMajorTickSpacing(580);
            timeForBal.setPaintLabels(true);
            timeForBal.setPaintTicks(true);
            zae.fill = GridBagConstraints.HORIZONTAL;
            zae.gridwidth = 3;
            zae.gridx = 0;
            zae.gridy = 0;
            slider.add(listOfFact.get(cbOfFactories.getSelectedIndex()).getJl(), zae);
            zae.fill = GridBagConstraints.HORIZONTAL;
            zae.gridy = 1;
            slider.add(timeForBal, zae);
            zae.fill = GridBagConstraints.HORIZONTAL;
            zae.gridwidth = 1;
            zae.gridy = 2;
            slider.add(delFact, zae);
            zae.gridx = 1;
            slider.add(pauseFact, zae);
            zae.gridx = 2;
            slider.add(resumeFact, zae);


            facTmp.add(slider);
            facTmp.pack();
            facTmp.setSize(400, 200);
            facTmp.setLocationRelativeTo(jf);
            facTmp.setVisible(true);
        });

        delFact.addActionListener(e -> {
            synchronized (listOfFact.get(cbOfFactories.getSelectedIndex())) {
                listOfFact.get(cbOfFactories.getSelectedIndex()).deletee();
                listOfFact.remove(cbOfFactories.getSelectedIndex());
                cbOfFactories.removeItemAt(cbOfFactories.getSelectedIndex());
                cbOfFactories.removeItem((cbOfFactories.getSelectedIndex()));
            }
        });

        pauseFact.addActionListener(e -> {
            synchronized (listOfFact.get(cbOfFactories.getSelectedIndex())) {
                listOfFact.get(cbOfFactories.getSelectedIndex()).stopp();
            }
        });
        resumeFact.addActionListener(e -> {
            synchronized (listOfFact.get(cbOfFactories.getSelectedIndex())) {
                listOfFact.get(cbOfFactories.getSelectedIndex()).continueMake();
            }
        });


        JButton delTrans = new JButton("Delete transporter");
        JButton pauseTrans = new JButton("Pause transporter");
        JButton resumeTrans = new JButton("Resume trans");


        cbOfTrans.addActionListener(e -> {
            GridBagLayout grigBag = new GridBagLayout();
            GridBagConstraints zae = new GridBagConstraints();
            JFrame transTmp = new JFrame("Transporter #" + cbOfTrans.getSelectedIndex());
            JPanel slider = new JPanel();
            slider.setLayout(grigBag);
            transTmp.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            zae.fill = GridBagConstraints.HORIZONTAL;
            zae.gridwidth = 3;
            zae.gridx = 1;
            zae.gridy = 0;
            slider.add(listOfTrans.get(cbOfTrans.getSelectedIndex()).getJl(), zae);
            zae.fill = GridBagConstraints.HORIZONTAL;
            zae.gridy = 1;
            zae.gridwidth = 1;
            slider.add(delTrans, zae);
            zae.gridx = 1;
            slider.add(pauseTrans, zae);
            zae.gridx = 2;
            slider.add(resumeTrans, zae);


            transTmp.add(slider);
            transTmp.pack();
            transTmp.setSize(450, 200);
            transTmp.setLocationRelativeTo(jf);
            transTmp.setVisible(true);
        });


        delTrans.addActionListener(
                e -> {
                    synchronized (listOfTrans.get(cbOfTrans.getSelectedIndex())) {
                        Thread.currentThread().interrupt();
                        cbOfTrans.remove(cbOfTrans.getSelectedIndex());
                    }
                }
        );
        pauseTrans.addActionListener(e -> {
            synchronized (listOfTrans.get(cbOfTrans.getSelectedIndex())) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException exception) {
                }
            }
        });
        resumeTrans.addActionListener(e -> {
            synchronized (listOfTrans.get(cbOfTrans.getSelectedIndex())) {
                Thread.currentThread().notify();
            }
        });


        GridLayout gridL = new GridLayout(2, 1);

        gridL.setHgap(8);
        gridL.setVgap(200);

        JPanel mainFac = new JPanel(gridL);

        mainFac.add(cbOfFactories);
        mainFac.add(addFact);

//


        JPanel mainTrans = new JPanel(gridL);
        mainTrans.add(cbOfTrans);
        mainTrans.add(addTrans);


//        JPanel storInfo = new JPanel(new BorderLayout());
//        JLabel currState =listOfFact.get(cbOfFactories.getSelectedIndex()).getJl();
//        currState.setHorizontalAlignment(JLabel.CENTER);
//        currState.setVerticalAlignment(JLabel.NORTH);
//
//
//        storInfo.add(currState, BorderLayout.NORTH);
//        storInfo.add(timeForBal, BorderLayout.SOUTH);
//        jf.add(storInfo, BorderLayout.CENTER);


        jf.add(mainFac, BorderLayout.WEST);
        jf.add(mainTrans, BorderLayout.EAST);
        jf.pack();
        jf.setSize(400, 300);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }
}
