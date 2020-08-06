package edu.kursova.panels;

import edu.kursova.figures.Circle;
import edu.kursova.figures.Figure;
import edu.kursova.figures.Quad;
import edu.kursova.figures.Triangle;
import edu.kursova.general.ReferencesBroker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonsPanel1 extends JPanel {


    private int panelWidth, panelHeight;
    private SettingsPanel1 sp1;
    private SettingsPanel2 sp2;

    private StatisticsPanel stP;
    private secondStatPanel stP2;
    private FiguresPanel fp;
    private JLabel statusInformationLabel;
    private String statusMessage;
    private ArrayList<Figure> figures;

    public ButtonsPanel1(int width, int height) {
        //creation of array
        figures = new ArrayList<Figure>();

        panelHeight = height;
        panelWidth = width;

        FlowLayout f1 = new FlowLayout(FlowLayout.LEFT, 5, 5);
        setLayout(f1);

        //line 1
        JPanel line1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 3));
        line1.setPreferredSize(new Dimension(280, 35));
        JButton btnShow = new JButton("Зобразити");
        JButton btnClear = new JButton("Очистити");
        line1.add(btnShow);
        line1.add(btnClear);

        //adding listeners for buttons
        btnShow.addActionListener(new BtnShowListener());
        btnClear.addActionListener(new BtnClearListener());

        //getting info about set panel
        this.sp1 = ReferencesBroker.getSettingsPanel1Ref();
        this.sp2 = ReferencesBroker.getSettingsPanel2Ref();
        this.fp = ReferencesBroker.getFiguresPanelRef();
        this.stP = ReferencesBroker.getStatisticsPanel();
        this.stP2 = ReferencesBroker.getStatisticsPanel2();

        //adding info panel
        JPanel line2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));
        JLabel statusInformationLabelTitle = new JLabel("статус останньої операціі:                 ");
        line2.add(statusInformationLabelTitle);

        //adding info panel
        JPanel line3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));
        statusMessage = "Успішно";
        statusInformationLabel = new JLabel(statusMessage);

        line3.add(statusInformationLabel);

        add(line1);
        add(line2);
        add(line3);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(panelWidth, panelHeight);
    }

    class BtnShowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            //reaction for button show
            boolean errorInAmountOfQuads = false, errorAmountOfTriangles = false, errorAmountOfCircles = false;
            boolean errorInFixedSize = false, errorInIntervalSize = false;
            int numOfQuadsFrom = 0;
            int numOfQuadsTo = 0;
            int numOfTrianglesFrom = 0;
            int numOfTrianglesTo = 0;
            int numOfCirclesFrom = 0;
            int numOfCirclesTo = 0;
            int figuresSizeFixed = 0;
            int figuresSizeFrom = 0;
            int figuresSizeTo = 0;


            statusMessage = "ok";

            if (sp1.isQuadSelected()) {
                //getting amount of situation A
                String quadsFrom = sp1.getValueQuadsFrom();
                String quadsTo = sp1.getValueQuadsTo();

                //getting number of situation A
                try {
                    numOfQuadsFrom = Integer.parseInt(quadsFrom);
                    numOfQuadsTo = Integer.parseInt(quadsTo);
                    if (numOfQuadsFrom<=0 ){
                        throw new NumberFormatException();
                    }
                    else if (numOfQuadsTo<=0){
                        throw new NumberFormatException();
                    }


                } catch (Exception e) {
                    errorInAmountOfQuads = true;
                    statusMessage = "The problem in event A";

                }


                //getting number of situation B
            }
            if (sp1.isTriangleSelected()) {
                //getting amount of situation B
                String trianglesFrom = sp1.getValueTrianglesFrom();
                String trianglesTo = sp1.getValueTrianglesTo();


                //getting number of situation B
                try {
                    numOfTrianglesFrom = Integer.parseInt(trianglesFrom);
                    numOfTrianglesTo = Integer.parseInt(trianglesTo);
                    if (numOfTrianglesFrom<=0 ){
                        throw new NumberFormatException();
                    }
                    else if (numOfTrianglesTo<=0){
                        throw new NumberFormatException();
                    }
                } catch (Exception e) {
                    errorAmountOfTriangles = true;
                    statusMessage = "The problem in event B";

                }
            }


            //getting number of situation C

            if (sp1.isCirclesSelected()) {
                //getting amount of situation C
                String circlesFrom = sp1.getValueCircleFrom();
                String circlesTo = sp1.getValueCircleTo();

                //getting number of situation C
                try {
                    numOfCirclesFrom = Integer.parseInt(circlesFrom);
                    numOfCirclesTo = Integer.parseInt(circlesTo);
                    if (numOfCirclesFrom<=0 ){
                        throw new NumberFormatException();
                    }
                    else if (numOfCirclesTo<=0){
                        throw new NumberFormatException();
                    }
                } catch (Exception e) {
                    errorAmountOfCircles = true;
                    statusMessage = "The problem in event C";

                }


            }
            //analysing of figures
            if (sp2.isOptionSizeFixedSelected()) {
                //fixed size selected

                try {
                    figuresSizeFixed = Integer.parseInt(sp2.getValueSizeFixed());
                    if (figuresSizeFixed<=0 ){
                        throw new NumberFormatException();
                    }
                } catch (Exception e) {
                    errorInFixedSize = true;
                    statusMessage = "fixed size problems";
                }
            } else {
                //interval size selected
                try {
                    figuresSizeFrom = Integer.parseInt(sp2.getValueSizeFrom());
                    figuresSizeTo = Integer.parseInt(sp2.getValueSizeTo());
                    if (figuresSizeFrom<=0 ){
                        throw new NumberFormatException();
                    }
                    else if (figuresSizeTo<=0){
                        throw new NumberFormatException();
                    }
                } catch (Exception e) {
                    errorInIntervalSize = true;
                    statusMessage = "interval size problems";
                }
            }
            statusInformationLabel.setText(statusMessage);

            int figuresPanelWidth = fp.getPreferredSize().width;
            int figuresPanelHeight = fp.getPreferredSize().height;
            //creation of array of figures
            if (!errorInAmountOfQuads && !errorAmountOfCircles && !errorAmountOfTriangles && !errorInFixedSize && !errorInIntervalSize ) {
                //creation of quads
                for (int i = 0; i < ((int) (Math.random() * (numOfQuadsTo - numOfQuadsFrom) + numOfQuadsFrom)); i++) {
                    if (sp1.isQuadSelected()) {
                        int x = (int) (Math.random() * figuresPanelWidth);
                        int y = (int) (Math.random() * figuresPanelHeight);
                        int r = 0;

                        if (sp2.isOptionSizeFixedSelected()) {
                            r = figuresSizeFixed;
                        } else {
                            r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
                        }

                        Quad q = new Quad(x, y, r, Color.GREEN);
                        figures.add(q);

                    }
                }
                //creation of triangles
                for (int i = 0; i < ((int) (Math.random() * (numOfTrianglesTo - numOfTrianglesFrom) + numOfTrianglesFrom)); i++) {
                    if (sp1.isTriangleSelected()) {
                        int x = (int) (Math.random() * figuresPanelWidth);
                        int y = (int) (Math.random() * figuresPanelHeight);
                        int r = 0;
                        if (sp2.isOptionSizeFixedSelected()) {
                            r = figuresSizeFixed;
                        } else {
                            r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
                        }

                        Triangle t = new Triangle(x, y, r, Color.BLUE);
                        figures.add(t);

                    }
                }
                //creation of circles
                for (int i = 0; i < ((int) (Math.random() * (numOfCirclesTo - numOfCirclesFrom) + numOfCirclesFrom)); i++) {
                    if (sp1.isCirclesSelected()) {
                        int x = (int) (Math.random() * figuresPanelWidth);
                        int y = (int) (Math.random() * figuresPanelHeight);
                        int r = 0;
                        if (sp2.isOptionSizeFixedSelected()) {
                            r = figuresSizeFixed;
                        } else {
                            r = (int) (Math.random() * (figuresSizeTo - figuresSizeFrom) + figuresSizeFrom);
                        }

                        Circle cc = new Circle(x, y, r, Color.red);
                        figures.add(cc);

                    }
                }
                fp.setFiguresArray(figures);
                //arrays for the first stat
                int nA = 0, nB = 0, nC = 0;
                for (Figure f :
                        figures) {
                    if (f instanceof Circle)
                        nA++;
                    if (f instanceof Triangle)
                        nB++;
                    if (f instanceof Quad)
                        nC++;
                }

                //find the radius
                int s = 0, m = 0, l = 0;

                //arrays for the sec stat
                for (Figure f : figures) {
                    if (f instanceof Quad) {
                        try {
                            if (((Quad) f).getR() < 30) {
                                s++;
                            }
                            if (((((Quad) f).getR() > 30) && ((Quad) f).getR() < 60)) {
                                m++;
                            }
                            if (((Quad) f).getR() > 60) {
                                l++;
                            } else if (f instanceof Circle) {
                                if (((Circle) f).getR() < 30) {
                                    s++;
                                }
                                if (((((Circle) f).getR() > 30) && (((Circle) f).getR() < 60))) {
                                    m++;
                                }
                                if (((Circle) f).getR() > 60) {
                                    l++;
                                }
                            } else if (f instanceof  Triangle) {
                                if (((Triangle) f).getR() < 30) {
                                    s++;
                                }
                                if (((((Triangle) f).getR() > 30) && (((Triangle) f).getR() < 60))) {
                                    m++;
                                }
                                if (((Triangle) f).getR() > 60) {
                                    l++;
                                }

                            }
                        } catch (Exception exception) {
                            exception.getCause();
                        }

                        //facility the statistics
                        if ((!errorAmountOfCircles && !errorAmountOfTriangles && !errorInAmountOfQuads && !errorInFixedSize && !errorInIntervalSize) && (sp2.isOptionSizeFixedSelected() || sp2.isOptionSizeIntervalSelected())) {
                            int[] statData = {nA, nB, nC};
                            int[] statData2 = {s, m, l};

                            stP = ReferencesBroker.getStatisticsPanel();
                            stP.setData(statData, Color.RED);
                            stP2 = ReferencesBroker.getStatisticsPanel2();
                            stP2.setData2(statData2, Color.BLUE);
                        }
                    }
                }
                statusInformationLabel.setText(statusMessage);

            }

        }
    }

    class BtnClearListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent arg0) {
            //reaction for button clear
            figures.clear();
            fp.setFiguresArray(figures);
            int [] statData = {0,0,0};
            stP.setData(statData,Color.RED);
            int [] statData2 = {0,0,0};
            stP2.setData2(statData2, Color.BLUE);

        }
    }
}

