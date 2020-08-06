package edu.kursova.panels;

import javax.swing.*;
import java.awt.*;

public class secondStatPanel extends JPanel {
    private int panelWidth, panelHeight;
    private int data[];
    private Color barsColor;

    public secondStatPanel(int panelWidth, int panelHeight){
        setBorder(BorderFactory.createTitledBorder("Статистика по масштабу подій"));
        barsColor = Color.BLUE;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }
    //initialisation of array
    public void setData2 (int[] data, Color c){
        this.data = data;
        this.barsColor = c;
        repaint();
    }
    //draw the statistics
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data != null){
            showChart(g);
        }
    }
    public void setData (int[] data, Color c){
        this.data = data;
        this.barsColor = c;
        repaint();
    }

    //draw the statistics
    private void showChart(Graphics g){
        int p = 10;
        int N = data.length;
        int b = (int) Math.round(getWidth() / ((1+1.0/p) * N + 1.0 / p));
        int d = (int) ((double)b / p );

        int max = data[0];
        for (int i = 0; i < data.length; i++){
            if (data[i] > max)
                max = data[i];
        }

        int min = data[0];
        for (int i = 0; i<data.length; i++){
            if (min > data[i])
                min = data[i];
        }


        int h = 20;
        int maxBarLenght = getHeight() - h;
        double hy = (double) maxBarLenght / max;

        for (int i = 0; i < N; i++){
            int barHeight = (int) (hy * data[i]);
            int barWidth = b;

            int x = d + i * (b + d);
            int y = getHeight() - barHeight;

            g.setColor(barsColor);
            g.fillRect(x, y, barWidth, barHeight);

            setFont(new Font("Arial", Font.BOLD, 10));
            g.setColor(Color.WHITE);

            FontMetrics fm = g.getFontMetrics();

            int xPosMark = x+barWidth/2;
            int yPosMark = y+10;

            String text = (Integer.toString(data[i]));
            int stringWidth = fm.stringWidth(text);
            int stringAscent = fm.getAscent();

            int xBox = xPosMark - stringWidth/2;
            int yBox = yPosMark + stringAscent/2;

            //set the procents
            if (i == 0)
                g.drawString("<30%", xBox, yBox);
            else if (i == 1)
                g.drawString("30-60%", xBox, yBox);
            else if (i == 2)
                g.drawString("60>%", xBox, yBox);

            g.drawString(text, xBox, yBox+15);
        }

    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(panelWidth, panelHeight);
    }



}
