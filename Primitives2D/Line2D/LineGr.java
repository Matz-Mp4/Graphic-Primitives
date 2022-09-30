package Primitives2D.Line2D;
import java.awt.Graphics;
import java.awt.Color;

import Gui.GuiUtils;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Point2D.Point;
import Primitives2D.Point2D.PointGr;

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

  public void scale(double k, Point p) {
    setP1(new Point(getP1().getX() * k + p.getX()*(1 - k), getP1().getY() * k + p.getY()*(1 - k)));
    setP2(new Point(getP2().getX() * k + p.getX()*(1 - k), getP2().getY() * k+ p.getY()*(1 - k)));
  }


  public void rotation(Point p, double angule){

    double radian = angule * (Math.PI / 180);
    double cos = Math.cos(radian);
    double sin = Math.cos(radian);


    setP1(new Point(getP1().getX() * cos - getP1().getY() * sin + p.getX(), getP1().getX() * sin + getP1().getY() * cos + p.getY()));
    setP2(new Point(getP2().getX() * cos - getP2().getY() * sin + p.getX(), getP2().getX() * sin + getP2().getY() * cos + p.getY()));
  }


}
