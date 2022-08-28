package Primitives2D.Rectangle2D;

import Primitives2D.Rectangle2D.Rectangle;
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



public class RectangleGr extends Rectangle {
    private LineGr l1, l2, l3, l4;

    public RectangleGr(Point p1, Point p2){
        super((double)p1.getX(), (double)p1.getY(), (double)p2.getX(),(double)p2.getY());
    }

    public void draw(Graphics g){
        l1 = new LineGr(getL1()); l2 = new LineGr(getL2());
        l3 = new LineGr(getL3()); l4 = new LineGr(getL4());

        l1.draw(g); l2.draw(g);
        l3.draw(g); l4.draw(g);
    }

    public void erase(Graphics g) {     }
}