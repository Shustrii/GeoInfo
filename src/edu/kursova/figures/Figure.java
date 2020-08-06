package edu.kursova.figures;

import javax.swing.*;
import java.awt.*;

public class Figure extends JPanel {
    private Color color;
    private int type;
    public static final int CIRCLE = 1;
    public static final int QUAD = 2;
    public static final int TRIANGLE = 3;


    public Figure(int i, int i1) {
        this.type = 0;
        this.color = Color.BLACK;
    }

    public Figure(Color c) {
        this.color = c;
        this.type = 0;
    }

    public Color getColor(){
        return color;
    }


}
