package Primitives2D.Rectangle2D;

import Primitives2D.Rectangle2D.Rectangle;
import Primitives2D.Drawable;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;

import java.awt.Graphics;

import Gui.GuiUtils;

/**
 * Retângulo gráfico.
 *
 * @author Gabriel Cavalcanti
 * @version 15/08/2021
 */



public class RectangleGr extends Rectangle implements Drawable{
    private LineGr []lines = new LineGr [4];
    private final int MAX = 4;

    public RectangleGr(Point p1, Point p2){
        super((double)p1.getX(), (double)p1.getY(), (double)p2.getX(),(double)p2.getY());
    }

    public void draw(Graphics g){
        for(int i = 0; i < MAX; i++){
            lines[i] = new LineGr(getLine(i));
            lines[i].draw(g);
        }
    }

    public void erase(Graphics g) {    
        for(int i = 0; i < MAX; i++){
            lines[i].setLineColor(GuiUtils.getBackground());
            lines[i].draw(g);
        }
     }
}