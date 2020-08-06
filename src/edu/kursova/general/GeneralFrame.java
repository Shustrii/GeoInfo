package edu.kursova.general;

import edu.kursova.panels.ControlsPanel;
import edu.kursova.panels.FiguresPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;



public class GeneralFrame extends JFrame{

        GeneralFrame(){
            setSize(1200,650);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setTitle("Kursova. (c) Made by Zubets.S.V., 2020");
            LayoutManager layout = new FlowLayout();
            setLayout(layout);


            //left panel
            FiguresPanel figuresPanel = new FiguresPanel(760,605);
            ReferencesBroker.setFiguresPanelRef(figuresPanel);
            LineBorder border = new LineBorder(Color.BLACK,1);
            figuresPanel.setBorder(border);

            ImageIcon ImageIcon = new ImageIcon("img/part_of_map_of_UA.png");
            Image image = ImageIcon.getImage();
            figuresPanel.setImage(image);

            add(figuresPanel);



            //Controls panel
            ControlsPanel controlsPanel= new ControlsPanel(350,605);
            LineBorder border2 = new LineBorder(Color.red,1);
            controlsPanel.setBorder(border2);
            add(controlsPanel);
        }

        public static void main(String[] args) {
            GeneralFrame window = new GeneralFrame();
            window.setVisible(true);
            window.setResizable(false);


        }

}
