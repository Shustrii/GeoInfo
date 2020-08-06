package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel1 extends JPanel {



    private int panelWidth, panelHeight;
    private JCheckBox optionQuads;
    private JTextField valueQuadsFrom;
    private JTextField valueQuadsTo;
    private JCheckBox optionTriangles;
    private JTextField valueTrianglesFrom;
    private JTextField valueTrianglesTo;
    private JCheckBox optionCircle;
    private JTextField valueCircleFrom;
    private JTextField valueCircleTo;


    public SettingsPanel1(int width, int height) {
        panelHeight =height;
        panelWidth = width;
        FlowLayout f1 = new FlowLayout(FlowLayout.LEFT,5,5);
        setLayout(f1);

        // adding line1 panel
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        line1.add(new JLabel("Події класу А"));
        optionQuads =  new JCheckBox();
        line1.add(optionQuads);
        //add the choose boxes
        valueQuadsFrom = new JTextField(4);
        valueQuadsTo = new JTextField(4);
        line1.add(new JLabel("від"));
        line1.add(valueQuadsFrom);
        line1.add(new JLabel("до"));
        line1.add(valueQuadsTo);

        //default values
        optionQuads.setSelected(true);
        valueQuadsFrom.setText("5");
        valueQuadsTo.setText("125");

        // adding line1 panel
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        line2.add(new JLabel("Події класу В"));
        optionTriangles =  new JCheckBox();
        line2.add(optionTriangles);
        //add the choose boxes
        valueTrianglesFrom = new JTextField(4);
        valueTrianglesTo = new JTextField(4);
        line2.add(new JLabel("від"));
        line2.add(valueTrianglesFrom);
        line2.add(new JLabel("до"));
        line2.add(valueTrianglesTo);

        // adding line1 panel
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,3));
        line3.add(new JLabel("Події класу C"));
        optionCircle =  new JCheckBox();
        line3.add(optionCircle);

        valueCircleFrom = new JTextField(4);
        valueCircleTo = new JTextField(4);
        line3.add(new JLabel("від"));
        line3.add(valueCircleFrom);
        line3.add(new JLabel("до"));
        line3.add(valueCircleTo);

        add(line1);
        add(line2);
        add(line3);

    }

    public boolean isQuadSelected(){
        return optionQuads.isSelected();
    }
    public String getValueQuadsFrom(){
        return valueQuadsFrom.getText();
    }
    public String getValueQuadsTo(){
        return valueQuadsTo.getText();
    }
    public boolean isTriangleSelected(){
        return optionTriangles.isSelected();
    }
    public String getValueTrianglesFrom(){
        return valueTrianglesFrom.getText();
    }
    public String getValueTrianglesTo(){
        return valueTrianglesTo.getText();
    }
    public boolean isCirclesSelected(){
        return optionCircle.isSelected();
    }
    public String getValueCircleFrom(){
        return valueCircleFrom.getText();
    }
    public String getValueCircleTo(){
        return valueCircleTo.getText();
    }



    @Override
    public Dimension getPreferredSize(){
        return new Dimension(panelWidth,panelHeight);
    }
}
