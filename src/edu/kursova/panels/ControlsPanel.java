package edu.kursova.panels;

import edu.kursova.general.ReferencesBroker;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ControlsPanel extends JPanel {
    private int panelWidth, panelHeight;

    public ControlsPanel(int width, int height) {
        panelHeight =height;
        panelWidth = width;

         FlowLayout f1 = new FlowLayout(FlowLayout.CENTER,0,10);
         setLayout(f1);

         //settings #1(selection of figures)

        SettingsPanel1 sp1 = new SettingsPanel1(310,100);
        ReferencesBroker.setSettingsPanel1Ref(sp1);
        sp1.setBorder(new LineBorder(Color.lightGray));

        add(sp1);

        //settings #2(customization of size)

        SettingsPanel2 sp2 = new SettingsPanel2(310,100);
        ReferencesBroker.setSettingsPanel2Ref(sp2);
        sp2.setBorder(new LineBorder(Color.lightGray));

        add(sp2);

        //adding statistic panel
        StatisticsPanel statP = new StatisticsPanel(310,90);
        statP.setBorder(new LineBorder(Color.lightGray));
        ReferencesBroker.setStatisticsPanel(statP);

        // adding stat panel 2
        secondStatPanel statP2 = new secondStatPanel(310,90);
        statP2.setBorder(new LineBorder(Color.lightGray));
        ReferencesBroker.setStatisticsPanel2(statP2);

        //Buttons panel #4(customization of size)

        ButtonsPanel1 bp1 = new ButtonsPanel1(310,100);
        bp1.setBorder(new LineBorder(Color.lightGray));

        JLabel lb1 = new JLabel("Статистика: по кількості подій різного типу");
        JLabel lb2 = new JLabel("Статистика: по маштабу подій");

        add(bp1);
        add(lb1);
        add(statP);
        add(lb2);
        add(statP2);



    }

    @Override
        public Dimension getPreferredSize(){
        return new Dimension(panelWidth,panelHeight);
    }
}
