package Primitives2D.Rectangle2D;

import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;

import java.awt.Graphics;



/**
 * Graphical rectangle.
 *
 * @author Gabriel Cavalcanti
 * @version 15/08/2022
 */

public class RectangleGr extends Rectangle {
    private LineGr l1, l2, l3, l4;

    /*  Constructor   */
    public RectangleGr(Point p1, Point p2){
        super((double)p1.getX(), (double)p1.getY(), (double)p2.getX(),(double)p2.getY());
    }

    /*
        This method instantiate graphical lines and passes all the lines of our rectangle to the class.
        Then, it calls the draw method from the LineGr class; that way, we print all four lines of the rectangle.
    */
    public void draw(Graphics g){
        l1 = new LineGr(getL1()); l2 = new LineGr(getL2());
        l3 = new LineGr(getL3()); l4 = new LineGr(getL4());

        l1.draw(g); l2.draw(g);
        l3.draw(g); l4.draw(g);
    }

    public void erase(Graphics g) {     }
}