package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    private int panelWidth, panelHeight;
    private int [] data;
    private Color barsColor;

    public StatisticsPanel(int width,int height){
        panelWidth = width;
        panelHeight = height;
        this.data = null;
        this.barsColor = Color.RED;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (data!=null){
            showChart(g);
        }
    }

    public void setData(int [] data,Color c){
        this.data=data;
        this.barsColor = c;
        repaint();
    }

    private void showChart(Graphics g){
        //showing bars chart
        int p = 10;
        int N = data.length;
        int b = (int)Math.round(getWidth()/((1+1.0/p)*N+1.0/p));
        int d =(int)((double)b/p);

        //find max bar length
        int max = data[0];
        for (int i = 0;i< data.length;i++){
            if (data[i]>max)
                max = data[i];
        }
        //find min bar length
        int min = data[0];
        for (int i =0;i<data.length;i++){
            if (min>data[i])
                min = data[i];
        }

        int h = 20;
        int maxBarLength = getHeight()- h;
        double hy =(double)maxBarLength/max;

        for (int i = 0;i<N;i++){
            int barHeight = (int)(hy*data[i]);
            int barWidth = b;

            int x =d+i*(b+d);
            int y = getHeight()-barHeight;

            g.setColor(barsColor);
            g.fillRect(x,y,barWidth,barHeight);

            //setting text marks
            //setting font and color
            setFont(new Font("Arial",Font.PLAIN,10));
            g.setColor(Color.WHITE);

            //getting font metrics for setted font from graphics context
            FontMetrics fm = g.getFontMetrics();

            //setting x and y of center of the text mark
            int xPosOfMark = x+barWidth/2;
            int yPosOfMark = y+10;

            //find width and height of mark text
            String markText =(new Integer(data[i])).toString();
            int stringWidth = fm.stringWidth(markText);
            int stringAscent = fm.getAscent();

            //find the coordinates of left-bottom corner of "box"
            int xBox = xPosOfMark - stringWidth/2;
            int yBox = yPosOfMark + stringAscent/2;

            if (i == 0)
                g.drawString("Подія C", xBox-10, yBox);
            else if (i == 1)
                g.drawString("Подія В", xBox-10, yBox);
            else if (i == 2)
                g.drawString("Подія A", xBox-10, yBox);

            g.drawString(markText, xBox, yBox+15);

        }

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(panelWidth,panelHeight);
    }
}
