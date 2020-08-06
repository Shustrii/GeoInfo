package edu.kursova.panels;

import edu.kursova.figures.Circle;
import edu.kursova.figures.Figure;
import edu.kursova.figures.Quad;
import edu.kursova.figures.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresPanel extends JPanel {
    private int panelWidth , panelHeight;
    private Image image;
    private ArrayList<Figure>figuresArray;
   public FiguresPanel(int width , int height){
       panelWidth = width;
       panelHeight = height;
       this.figuresArray = new ArrayList<Figure>();

   }
   public FiguresPanel(){
       this(100,100);
   }
   public void setFiguresArray(ArrayList<Figure> f){
        this.figuresArray = f;
        repaint();
   }


@Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    if(image!=null){
        g.drawImage(image, 0,0,getWidth(),getHeight(),this);
    }


    if (figuresArray!=null && figuresArray.size()!=0){
        for (Figure f: figuresArray){
            if(f instanceof Quad){
                //drawing quads
                Quad fQ = ((Quad)f);
                Color color = fQ.getColor();
                g.setColor(color);
                drawFigure(g, Figure.QUAD,fQ.getX(),fQ.getY(),fQ.getR());
            }
            else if (f instanceof Triangle){
                //drawing triangles
                Triangle fT = ((Triangle)f);
                Color color = fT.getColor();
                g.setColor(color);
                drawFigure(g, Figure.TRIANGLE,fT.getX(),fT.getY(),fT.getR());
            }
            else if (f instanceof Circle){
                //drawing circles
                Circle fC = ((Circle)f);
                Color color = fC.getColor();
                g.setColor(color);
                drawFigure(g, Figure.CIRCLE,fC.getX(),fC.getY(),fC.getR());
            }
        }
    }
    showGrid(g,30,Color.LIGHT_GRAY,true,Color.WHITE);
    }

    public void setImage(Image image){
        this.image = image;
        repaint();
    }
    private void drawFigure(Graphics g,int type, int x,int y,int r){

        if (type == Figure.QUAD){
            //draw the quad
            int newWidth = r*2;
            int newHeight = r*2;
            int newX = x-r;
            int newY = y-r;
            g.setColor(Color.GREEN);
            g.fillRect(newX,newY,newWidth,newHeight);
        }
        else if (type== Figure.TRIANGLE){
            //draw the triangle
            int a = (int)Math.round(r*Math.sqrt(3));
            int v1 = (int)Math.round(Math.sqrt(r*r-a*a/4));
            int x1 = x;
            int y1 = y - r;
            int x2 = x-a/2;
            int y2 = y + v1;
            int x3 = x+a/2;
            int y3 = y+v1;

            int [] xx = {x1,x2,x3};
            int [] yy = {y1,y2,y3};
            g.setColor(Color.blue);
            g.fillPolygon(xx,yy,3);
        }
        else if (type == Figure.CIRCLE){
            //draw the circle

            int newX = x-r;
            int newY = y-r;
            int newWidth = 2*r;
            int newHeight = 2*r;


            g.setColor(Color.red);
            g.drawLine(x,y,x,y);
            g.fillOval(newX,newY,newWidth,newHeight);

        }
    }


    public void showGrid(Graphics g, int size, Color lightGray, boolean b, Color c) {
        g.setColor(c);

        int pWidth = getWidth();
        int pHeight = getHeight();

        int vertLines = getWidth() / size;
        int horLines = getHeight() / size;

        for (int i = 1; i <= horLines; i++) {
            g.drawLine(0, i * size, pWidth - 1, i * size);
        }

        for (int i = 1; i <= vertLines; i++) {
            g.drawLine(i * size, 0, i * size, pHeight - 1);
        }
        Font f = new Font("Dialog", Font.PLAIN, size / 4);
        FontMetrics fm = getFontMetrics(f);
        setFont(f);

        final int k = 45;

        for (int i = 1; i <= vertLines; i++) {

            String msg = "" + k * i;
            int x = i * size - fm.stringWidth(msg) / 2;
            int y = fm.getHeight();
            g.setColor(Color.WHITE);
            g.fillRect(x, y / 3, size / 2, size / 3);
            g.setColor(Color.BLACK);
            g.drawString(msg, x, y);
        }

        for (int i = 1; i <= horLines; i++) {

            String msg = "" + k * i;
            int x = size / 4;
            int y = i * size + fm.getHeight() / 4;
            g.setColor(Color.WHITE);
            g.fillRect(x, i * size - fm.getHeight() / 2, size / 2, size / 3);
            g.setColor(Color.BLACK);
            g.drawString(msg, x, y);

        }

        g.drawRect(0, 0, pWidth - 1, pHeight - 1);

    }



@Override
    public Dimension getPreferredSize(){
       return new Dimension(panelWidth,panelHeight);
}
}
