package Primitives2D.Line2D;
import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Point2D.*;

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
   * @param g
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

  public void erase(Graphics g) {
    setLineColor(GuiUtils.getBackground());
    draw(g);
    setLineColor(GuiUtils.getForeground());

  }

  public void changeThickness(int value){
    setThickness(value);
  }


  public void changeColor(Color newColor){
    setLineColor(newColor);
  }

  public void translation(Point p){
    
    int dx =(int)( p.getX() - getP1().getX());
    int dy = (int)( p.getY() - getP1().getY());

    setP1(new Point(getP1().getX() + dx, getP1().getY() + dy));
    setP2(new Point(getP2().getX() + dx, getP2().getY() + dy));

    
  }


}
