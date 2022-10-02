package Primitives2D.Line2D;
import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;


  /**
   * Class that handles the line Graphical
   */
 
public class LineGr extends SuperLineGr implements PrimitiveGr2D {

  public LineGr(SuperLineGr line) {
    super(line);
  }

  public LineGr(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
  }

  public LineGr(PointGr p1, PointGr p2) {
    super(p1, p2);
  }

  public LineGr(Line l) {
    super(l.getP1(), l.getP2());
  }


  /**
   * draw a line 
   * @param Graphics g
   */
  public void draw(Graphics g) {
    // y = a * x + b, a = line inclination
    double b, a, x, y;
    double beginX, endX, beginY, endY;
    PointGr point = new PointGr();
    point.setDiameter(getThickness());

    beginX = getP1().getX();
    endX = getP2().getX();
    beginY = getP1().getY();
    endY = getP2().getY();

    if (getP1().getX() > getP2().getX()) {
      // Swap the coordinates
      beginX = getP2().getX();
      endX = getP1().getX();

    }
    if (getP1().getY() > getP2().getY()) {
      // Swap the coordinates
      beginY = getP2().getY();
      endY = getP1().getY();

    }

    double dy = endY - beginY;
    double dx = endX - beginX;
    // Vertical Line
    if (getP1().getX() == getP2().getX()) {
      a = 0;

      for (y = beginY; y <= endY; y++) {
        point.setX((int) beginX);
        point.setY((int) y);
        point.setPointColor(getLineColor());
        point.drawPoint(g);
      }

      // Horizontal Line
    } else if (getP1().getY() == getP2().getY()) {

      y = beginY;
      for (x = beginX; x <= endX; x++) {
        point.setX((int) x);
        point.setY((int) y);
        point.setPointColor(getLineColor());
        point.drawPoint(g);
      }

    } else {
      a = calculateInclination();
      // Calculate the linear term of the line
      b = calculateB();

      if (dy > dx) {
        for (y = beginY; y <= endY; y++) {
          x = (y - b) / a;
          x = Math.round(x);
          point.setX((int) x);
          point.setY((int) y);
          point.setPointColor(getLineColor());
          point.drawPoint(g);
        }
      } else {
        for (x = beginX; x <= endX; x++) {
          y = a * x + b;
          y = Math.round(y);
          point.setX((int) x);
          point.setY((int) y);
          point.setPointColor(getLineColor());
          point.drawPoint(g);

        }

      }
    }
  }

  /**
   * erase a line 
   * @param Graphics g
   */
 
  public void erase(Graphics g) {
    Color lineColor = getLineColor();
    setLineColor(GuiUtils.getBackground());
    draw(g);
    setLineColor(lineColor);

  }

  /**
   * change the thickness of  line 
   * @param int value
   */
  public void changeThickness(int value){
    setThickness(value);
  }

  /**
   * change the color of  line 
   * @param Color color
   */
 
  public void changeColor(Color newColor){
    setLineColor(newColor);
  }

  /**
   * move the line to a point  
   * @param Point p
   */
  public void translation(Point p){
    translationLine(p);
    
  }

  /**
   * change the size of the line  
   * @param double k, Point p, 
   */
  public void scale(double k, Point p) {
    scaleLine(k, p);
  }


  /**
   * rotate the line from reference point  
   * @param double k, Point p, 
   */
  public void rotation(Point p, double angle){
    rotationLine(p, angle);
  }


}
