package edu.kursova.figures;

import java.awt.*;

public class Circle extends Figure {
    private int x,y,r;

    public Circle(int x, int y, int r, Color c){
        super(c);
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public  int getR(){
        return r;
    }
}
