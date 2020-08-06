package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel2 extends JPanel {


    private int panelWidth, panelHeight;
    private JRadioButton optionSizeFixed;
    private  JRadioButton optionSizeInterval;
    private JTextField valueSizeFixed;
    private JTextField valueSizeFrom;
    private JTextField valueSizeTo;

    public SettingsPanel2(int width, int height) {
        panelHeight =height;
        panelWidth = width;
        FlowLayout f1 = new FlowLayout(FlowLayout.LEFT,5,5);
        setLayout(f1);

        //line 1
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        line1.add(new JLabel("Розміри фігур (радіус)"));

        //creation of radio buttons

        optionSizeFixed = new JRadioButton("Фіксований");
        optionSizeInterval = new JRadioButton("Довільний");

        //grouping rb
        ButtonGroup rbGr = new ButtonGroup();
        rbGr.add(optionSizeFixed);
        rbGr.add(optionSizeInterval);

        //adding line 2
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        valueSizeFixed = new JTextField(4);
        line2.add(optionSizeFixed);
        line2.add(valueSizeFixed);
        //deff settings
        optionSizeFixed.setSelected(true);
        valueSizeFixed.setText("5");

        //adding line 3
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        valueSizeFrom = new JTextField(4);
        valueSizeTo = new JTextField(4);
        line3.add(optionSizeInterval);
        line3.add(new JLabel("від"));
        line3.add(valueSizeFrom);
        line3.add(new JLabel("до"));
        line3.add(valueSizeTo);

        add(line1);
        add(line2);
        add(line3);


    }

    public boolean isOptionSizeFixedSelected(){
        return optionSizeFixed.isSelected();
    }
    public boolean isOptionSizeIntervalSelected(){
        return optionSizeInterval.isSelected();
    }
    public String getValueSizeFixed(){
        return valueSizeFixed.getText();
    }
    public String getValueSizeFrom(){
        return valueSizeFrom.getText();
    }
    public String getValueSizeTo(){
        return valueSizeTo.getText();
    }




    @Override
    public Dimension getPreferredSize(){
        return new Dimension(panelWidth,panelHeight);
    }
}
